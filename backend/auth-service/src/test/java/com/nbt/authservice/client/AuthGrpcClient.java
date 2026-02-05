package com.nbt.authservice.client;

import com.nbt.proto.auth.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AuthGrpcClient {

    private final AuthServiceGrpc.AuthServiceBlockingStub stub;

    public AuthGrpcClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = AuthServiceGrpc.newBlockingStub(channel);
    }

    public LoginResponse login(String username, String password) {
        try {
            return stub.login(LoginRequest.newBuilder()
                    .setUsername(username)
                    .setPassword(password)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ValidateTokenResponse validateToken(String token) {
        return stub.validateToken(ValidateTokenRequest.newBuilder().setToken(token).build());
    }
}
