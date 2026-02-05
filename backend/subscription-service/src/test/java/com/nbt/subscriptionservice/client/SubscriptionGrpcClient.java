package com.nbt.subscriptionservice.client;

import com.nbt.proto.subscription.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SubscriptionGrpcClient {

    private final SubscriptionServiceGrpc.SubscriptionServiceBlockingStub stub;

    public SubscriptionGrpcClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = SubscriptionServiceGrpc.newBlockingStub(channel);
    }

    public Subscription subscribe(String userId, String serviceId) {
        return stub.subscribe(SubscribeRequest.newBuilder()
                .setUserId(userId)
                .setServiceId(serviceId)
                .build());
    }
}
