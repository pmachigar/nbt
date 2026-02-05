package com.nbt.catalogservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "services")
public class ServiceItem {
    @Id
    private String id;
    private String description;
    private Double rate;
    private String unitOfMeasure;
}
