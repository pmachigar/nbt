package com.nbt.authservice.service;

import com.nbt.authservice.domain.AuthUser;
import com.nbt.authservice.repository.AuthRepository;
import com.nbt.authservice.security.JwtUtils;
import com.nbt.proto.auth.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@GrpcService
@RequiredArgsConstructor
public class AuthServiceImpl extends AuthServiceGrpc.AuthServiceImplBase {

    private final AuthRepository authRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        authRepository.findByUsername(request.getUsername())
                .ifPresentOrElse(user -> {
                    if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                        if (user.isMfaEnabled()) {
                            // MFA Flow
                            String tempToken = jwtUtils.generateToken(user.getUsername(), user.getUserId()); // Simplified
                                                                                                             // temp
                                                                                                             // token
                            responseObserver.onNext(LoginResponse.newBuilder()
                                    .setMfaRequired(true)
                                    .setTempToken(tempToken)
                                    .build());
                        } else {
                            // Standard Login
                            String token = jwtUtils.generateToken(user.getUsername(), user.getUserId());
                            responseObserver.onNext(LoginResponse.newBuilder()
                                    .setToken(token)
                                    .setMfaRequired(false)
                                    .build());
                        }
                        responseObserver.onCompleted();
                    } else {
                        responseObserver.onError(io.grpc.Status.UNAUTHENTICATED
                                .withDescription("Invalid credentials").asRuntimeException());
                    }
                }, () -> responseObserver.onError(io.grpc.Status.UNAUTHENTICATED
                        .withDescription("User not found").asRuntimeException()));
    }

    @Override
    public void validateToken(ValidateTokenRequest request, StreamObserver<ValidateTokenResponse> responseObserver) {
        try {
            String username = jwtUtils.extractUsername(request.getToken());
            boolean valid = jwtUtils.validateToken(request.getToken(), username);
            responseObserver.onNext(ValidateTokenResponse.newBuilder()
                    .setValid(valid)
                    .setUserId(username) // In a real app map back to userId if needed or extract from claims
                    .build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onNext(ValidateTokenResponse.newBuilder().setValid(false).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void requestTwoFactor(TwoFactorRequest request, StreamObserver<TwoFactorResponse> responseObserver) {
        // Mock implementation: In reality, send SMS/Email here
        responseObserver.onNext(TwoFactorResponse.newBuilder()
                .setSent(true)
                .setMessage("Code sent to your " + request.getMethod())
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void verifyTwoFactor(VerifyTwoFactorRequest request, StreamObserver<LoginResponse> responseObserver) {
        // Mock implementation: Verify code "123456"
        if ("123456".equals(request.getCode())) {
            // In reality, validate tempToken first and extract user
            String mockUsername = jwtUtils.extractUsername(request.getTempToken());
            // Fetch user to get ID... simplifying for now
            String token = jwtUtils.generateToken(mockUsername, "user-id-placeholder");

            responseObserver.onNext(LoginResponse.newBuilder()
                    .setToken(token)
                    .setMfaRequired(false)
                    .build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(io.grpc.Status.UNAUTHENTICATED
                    .withDescription("Invalid 2FA Code").asRuntimeException());
        }
    }
}
