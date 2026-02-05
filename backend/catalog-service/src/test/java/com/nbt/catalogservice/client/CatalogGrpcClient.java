package com.nbt.catalogservice.client;

import com.nbt.proto.catalog.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CatalogGrpcClient {

    private final CatalogServiceGrpc.CatalogServiceBlockingStub stub;

    public CatalogGrpcClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = CatalogServiceGrpc.newBlockingStub(channel);
    }

    public ServiceItem createService(String description, double rate, String unit) {
        return stub.createService(CreateServiceRequest.newBuilder()
                .setDescription(description)
                .setRate(rate)
                .setUnitOfMeasure(unit)
                .build());
    }

    public ListServicesResponse listServices() {
        return stub.listServices(ListServicesRequest.newBuilder().setPage(0).setSize(10).build());
    }
}
