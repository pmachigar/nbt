package com.nbt.userservice.client;

import com.nbt.proto.user.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UserGrpcClient {

    private final UserServiceGrpc.UserServiceBlockingStub stub;

    public UserGrpcClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = UserServiceGrpc.newBlockingStub(channel);
    }

    public UserResponse createUser(String idDoc, String nombre, String email) {
        CreateUserRequest request = CreateUserRequest.newBuilder()
                .setIdDocumento(idDoc)
                .setNombre(nombre)
                .setContacto(Contact.newBuilder().setEmail(email).build())
                .build();
        return stub.createUser(request);
    }
    
    public UserResponse getUser(String idDoc) {
        return stub.getUser(GetUserRequest.newBuilder().setIdDocumento(idDoc).build());
    }
}
