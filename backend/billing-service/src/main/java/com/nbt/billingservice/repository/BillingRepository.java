package com.nbt.billingservice.repository;

import com.nbt.billingservice.domain.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends MongoRepository<Invoice, String> {
    List<Invoice> findByUserId(String userId);
}
