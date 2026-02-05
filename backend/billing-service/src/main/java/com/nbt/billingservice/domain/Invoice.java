package com.nbt.billingservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "invoices")
public class Invoice {
    @Id
    private String id;
    private String userId;
    private List<InvoiceItem> items;
    private Double totalValue;
    private String issueDate;
    private String status; // PENDING, PAID

    @Data
    public static class InvoiceItem {
        private String description;
        private Double amount;
        private Integer quantity;
    }
}
