package com.nbt.userservice.service;

import com.nbt.proto.user.*;
import com.nbt.userservice.domain.User;
import com.nbt.userservice.mapper.UserMapper;
import com.nbt.userservice.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    private final UserRepository userRepository;

    @Override
    public void createUser(CreateUserRequest request, StreamObserver<UserResponse> responseObserver) {
        User user = UserMapper.toDomain(request);
        User savedUser = userRepository.save(user);
        responseObserver.onNext(UserMapper.toProto(savedUser));
        responseObserver.onCompleted();
    }

    @Override
    public void getUser(GetUserRequest request, StreamObserver<UserResponse> responseObserver) {
        userRepository.findByIdDocumento(request.getIdDocumento())
                .ifPresentOrElse(
                        user -> {
                            responseObserver.onNext(UserMapper.toProto(user));
                            responseObserver.onCompleted();
                        },
                        () -> responseObserver.onError(io.grpc.Status.NOT_FOUND
                                .withDescription("User not found")
                                .asRuntimeException()));
    }

    // Implement other methods as needed (Update, Delete)
}
