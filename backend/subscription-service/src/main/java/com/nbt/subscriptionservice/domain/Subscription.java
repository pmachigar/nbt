package com.nbt.subscriptionservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "subscriptions")
public class Subscription {
    @Id
    private String id;
    private String userId;
    private String serviceId;
    private Double rate;
    private String status; // ACTIVE, CANCELLED
    private LocalDate startDate;
    private LocalDate endDate;
}
