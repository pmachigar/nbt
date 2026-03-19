package com.nbt.billingservice.service;

import com.nbt.billingservice.domain.Invoice;
import com.nbt.billingservice.repository.BillingRepository;
import com.nbt.proto.billing.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@GrpcService
@RequiredArgsConstructor
public class BillingServiceImpl extends BillingServiceGrpc.BillingServiceImplBase {

    private final BillingRepository billingRepository;

    @Override
    public void generateInvoice(GenerateInvoiceRequest request,
            StreamObserver<com.nbt.proto.billing.Invoice> responseObserver) {
        // Logic: Fetch subscriptions from SubscriptionService (simulated here)
        // Calculate total

        Invoice invoice = new Invoice();
        invoice.setUserId(request.getUserId());
        invoice.setIssueDate(LocalDate.now().toString());
        invoice.setStatus("PENDING");

        List<Invoice.InvoiceItem> items = new ArrayList<>();
        double total = 0.0;

        // Mock generation based on requested subscription IDs
        for (String subId : request.getSubscriptionIdsList()) {
            Invoice.InvoiceItem item = new Invoice.InvoiceItem();
            item.setDescription("Service Charge for Subscription " + subId);
            item.setQuantity(1);
            item.setAmount(100.0 + new Random().nextInt(50)); // Random amount for demo

            items.add(item);
            total += item.getAmount();
        }

        invoice.setItems(items);
        invoice.setTotalValue(total);

        Invoice saved = billingRepository.save(invoice);
        responseObserver.onNext(toProto(saved));
        responseObserver.onCompleted();
    }

    @Override
    public void getInvoices(GetInvoicesRequest request, StreamObserver<GetInvoicesResponse> responseObserver) {
        List<com.nbt.proto.billing.Invoice> invoices = billingRepository.findByUserId(request.getUserId())
                .stream()
                .map(this::toProto)
                .collect(Collectors.toList());

        responseObserver.onNext(GetInvoicesResponse.newBuilder()
                .addAllInvoices(invoices)
                .build());
        responseObserver.onCompleted();
    }

    private com.nbt.proto.billing.Invoice toProto(Invoice domain) {
        List<com.nbt.proto.billing.InvoiceItem> protoItems = domain.getItems() != null
                ? domain.getItems().stream().map(item -> toProtoItem(item)).collect(Collectors.toList())
                : new ArrayList<>();

        return com.nbt.proto.billing.Invoice.newBuilder()
                .setId(domain.getId())
                .setUserId(domain.getUserId())
                .setTotalValue(domain.getTotalValue() != null ? domain.getTotalValue() : 0.0)
                .setIssueDate(domain.getIssueDate())
                .setStatus(domain.getStatus())
                .addAllItems(protoItems)
                .build();
    }

    private com.nbt.proto.billing.InvoiceItem toProtoItem(Invoice.InvoiceItem domain) {
        return com.nbt.proto.billing.InvoiceItem.newBuilder()
                .setDescription(domain.getDescription())
                .setAmount(domain.getAmount())
                .setQuantity(domain.getQuantity())
                .build();
    }
}
