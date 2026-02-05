package com.nbt.subscriptionservice.service;

import com.nbt.proto.subscription.*;
import com.nbt.subscriptionservice.domain.Subscription;
import com.nbt.subscriptionservice.repository.SubscriptionRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
@RequiredArgsConstructor
public class SubscriptionServiceImpl extends SubscriptionServiceGrpc.SubscriptionServiceImplBase {

    private final SubscriptionRepository subscriptionRepository;

    // In a real microservice architecture, we would need a Feign Client or gRPC
    // Stub
    // to call CatalogService to get the rate, but for now we will simulate it or
    // pass it.
    // The proto definition for SubscribeRequest only has userId and serviceId.
    // We'll assume a fixed rate or look it up later. For this simplified
    // implementation, we'll mock the rate lookup.

    @Override
    public void subscribe(SubscribeRequest request,
            StreamObserver<com.nbt.proto.subscription.Subscription> responseObserver) {
        Subscription subscription = new Subscription();
        subscription.setUserId(request.getUserId());
        subscription.setServiceId(request.getServiceId());
        subscription.setStatus("ACTIVE");
        subscription.setStartDate(LocalDate.now());
        subscription.setRate(100.0); // Mock rate, should come from Catalog Service

        Subscription saved = subscriptionRepository.save(subscription);
        responseObserver.onNext(toProto(saved));
        responseObserver.onCompleted();
    }

    @Override
    public void unsubscribe(UnsubscribeRequest request,
            StreamObserver<com.nbt.proto.subscription.Subscription> responseObserver) {
        subscriptionRepository.findById(request.getSubscriptionId())
                .ifPresentOrElse(sub -> {
                    sub.setStatus("CANCELLED");
                    sub.setEndDate(LocalDate.now());
                    Subscription saved = subscriptionRepository.save(sub);
                    responseObserver.onNext(toProto(saved));
                    responseObserver.onCompleted();
                }, () -> responseObserver.onError(io.grpc.Status.NOT_FOUND
                        .withDescription("Subscription not found").asRuntimeException()));
    }

    @Override
    public void getUserSubscriptions(GetUserSubscriptionsRequest request,
            StreamObserver<GetUserSubscriptionsResponse> responseObserver) {
        List<com.nbt.proto.subscription.Subscription> subs = subscriptionRepository.findByUserId(request.getUserId())
                .stream()
                .map(this::toProto)
                .collect(Collectors.toList());

        responseObserver.onNext(GetUserSubscriptionsResponse.newBuilder()
                .addAllSubscriptions(subs)
                .build());
        responseObserver.onCompleted();
    }

    private com.nbt.proto.subscription.Subscription toProto(Subscription domain) {
        return com.nbt.proto.subscription.Subscription.newBuilder()
                .setId(domain.getId())
                .setUserId(domain.getUserId())
                .setServiceId(domain.getServiceId())
                .setRate(domain.getRate() != null ? domain.getRate() : 0.0)
                .setStatus(domain.getStatus())
                .setStartDate(domain.getStartDate().toString())
                .setEndDate(domain.getEndDate() != null ? domain.getEndDate().toString() : "")
                .build();
    }
}
