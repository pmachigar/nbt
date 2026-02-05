package com.nbt.catalogservice.service;

import com.nbt.catalogservice.domain.ServiceItem;
import com.nbt.catalogservice.repository.CatalogRepository;
import com.nbt.proto.catalog.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
@RequiredArgsConstructor
public class CatalogServiceImpl extends CatalogServiceGrpc.CatalogServiceImplBase {

    private final CatalogRepository catalogRepository;

    @Override
    public void createService(CreateServiceRequest request,
            StreamObserver<com.nbt.proto.catalog.ServiceItem> responseObserver) {
        ServiceItem item = new ServiceItem();
        item.setDescription(request.getDescription());
        item.setRate(request.getRate());
        item.setUnitOfMeasure(request.getUnitOfMeasure());

        ServiceItem saved = catalogRepository.save(item);

        responseObserver.onNext(toProto(saved));
        responseObserver.onCompleted();
    }

    @Override
    public void getService(GetServiceRequest request,
            StreamObserver<com.nbt.proto.catalog.ServiceItem> responseObserver) {
        catalogRepository.findById(request.getId())
                .ifPresentOrElse(
                        item -> {
                            responseObserver.onNext(toProto(item));
                            responseObserver.onCompleted();
                        },
                        () -> responseObserver.onError(io.grpc.Status.NOT_FOUND
                                .withDescription("Service not found").asRuntimeException()));
    }

    @Override
    public void listServices(ListServicesRequest request, StreamObserver<ListServicesResponse> responseObserver) {
        int page = request.getPage() > 0 ? request.getPage() : 0;
        int size = request.getSize() > 0 ? request.getSize() : 10;

        List<com.nbt.proto.catalog.ServiceItem> items = catalogRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(this::toProto)
                .collect(Collectors.toList());

        long count = catalogRepository.count();

        responseObserver.onNext(ListServicesResponse.newBuilder()
                .addAllServices(items)
                .setTotalCount(count)
                .build());
        responseObserver.onCompleted();
    }

    private com.nbt.proto.catalog.ServiceItem toProto(ServiceItem domain) {
        return com.nbt.proto.catalog.ServiceItem.newBuilder()
                .setId(domain.getId())
                .setDescription(domain.getDescription())
                .setRate(domain.getRate())
                .setUnitOfMeasure(domain.getUnitOfMeasure())
                .build();
    }
}
