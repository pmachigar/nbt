package com.nbt.catalogservice.repository;

import com.nbt.catalogservice.domain.ServiceItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends MongoRepository<ServiceItem, String> {
}
