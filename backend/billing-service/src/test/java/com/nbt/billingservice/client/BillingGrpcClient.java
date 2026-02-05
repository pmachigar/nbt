package com.nbt.billingservice.client;

import com.nbt.proto.billing.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class BillingGrpcClient {

    private final BillingServiceGrpc.BillingServiceBlockingStub stub;

    public BillingGrpcClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = BillingServiceGrpc.newBlockingStub(channel);
    }

    public Invoice generateInvoice(String userId, java.util.List<String> subIds) {
        return stub.generateInvoice(GenerateInvoiceRequest.newBuilder()
                .setUserId(userId)
                .addAllSubscriptionIds(subIds)
                .build());
    }
}
