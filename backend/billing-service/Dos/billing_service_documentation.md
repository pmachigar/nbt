# Billing Service Documentation

## 1. Overview
The **Billing Service** is a Spring Boot-based microservice responsible for generating and managing user invoices. It leverages **MongoDB** for persistent storage and exposes its operations via **gRPC** to ensure high-performance, strongly typed communication with other microservices in the ecosystem.

## 2. System Architecture

The service follows a standard layered architecture pattern integrated with gRPC:

```mermaid
graph TD
    Client["Client Services (e.g., API Gateway, Subscription Service)"] -- gRPC (Port 9094) --> gRPC_Server["BillingServiceGrpc Server"]
    gRPC_Server --> Service["BillingServiceImpl"]
    Service --> Repository["BillingRepository (Spring Data MongoDB)"]
    Repository -- MongoDB Protocol (Port 27017) --> DB[(MongoDB: billing-db)]
    
    subgraph Spring Boot Application
        gRPC_Server
        Service
        Repository
        Domain["Domain Model (Invoice)"]
    end
```

### Core Components:
- **`BillingServiceImpl`**: The core `@GrpcService` class that processes incoming requests.
- **`BillingRepository`**: Interface extending `MongoRepository` that handles database operations.
- **`proto-common`**: External shared module where the Protobuf descriptors (`BillingServiceGrpc`, `Invoice`, etc.) are defined.

## 3. Domain Model

The service domain consists of a main `Invoice` document that embeds multiple `InvoiceItem` sub-documents.

```mermaid
classDiagram
    class Invoice {
        +String id
        +String userId
        +List~InvoiceItem~ items
        +Double totalValue
        +String issueDate
        +String status
    }
    
    class InvoiceItem {
        +String description
        +Double amount
        +Integer quantity
    }
    
    Invoice "1" *-- "*" InvoiceItem : contains
```

- **`status`**: Can be `PENDING` or `PAID`.
- **`items`**: Represents individual line items for the services or subscriptions being billed.

## 4. gRPC Workflows

The service exposes the following main entry points. Below are the sequence diagrams illustrating their behavior.

### 4.1. Generating an Invoice (`generateInvoice`)
When an upstream service requests an invoice generation, the Billing Service currently creates mock invoice items based on the provided subscription IDs and persists the new invoice.

```mermaid
sequenceDiagram
    participant Client
    participant BillingServiceImpl
    participant MongoDB
    
    Client->>BillingServiceImpl: generateInvoice(GenerateInvoiceRequest)
    Note over Client,BillingServiceImpl: Request includes userId and List<SubscriptionId>
    
    activate BillingServiceImpl
    BillingServiceImpl->>BillingServiceImpl: Initialize new Invoice (status: PENDING)
    
    loop For each SubscriptionId
        BillingServiceImpl->>BillingServiceImpl: Generate mock InvoiceItem
        BillingServiceImpl->>BillingServiceImpl: Calculate running totalValue
    end
    
    BillingServiceImpl->>MongoDB: save(Invoice)
    MongoDB-->>BillingServiceImpl: Saved Invoice (with generated ID)
    
    BillingServiceImpl->>BillingServiceImpl: toProto(savedInvoice)
    Note over BillingServiceImpl,Client: Maps internal domain to gRPC Protobuf
    
    BillingServiceImpl-->>Client: onNext(Proto Invoice) & onCompleted()
    deactivate BillingServiceImpl
```

### 4.2. Retrieving User Invoices (`getInvoices`)
Allows retrieving the full history of invoices for a given user.

```mermaid
sequenceDiagram
    participant Client
    participant BillingServiceImpl
    participant MongoDB
    
    Client->>BillingServiceImpl: getInvoices(GetInvoicesRequest)
    Note over Client,BillingServiceImpl: Request includes userId
    
    activate BillingServiceImpl
    BillingServiceImpl->>MongoDB: findByUserId(userId)
    MongoDB-->>BillingServiceImpl: List<Invoice> (Domain objects)
    
    loop For each Domain Invoice
        BillingServiceImpl->>BillingServiceImpl: toProto(invoice)
    end
    
    BillingServiceImpl-->>Client: onNext(GetInvoicesResponse) & onCompleted()
    Note over Client,BillingServiceImpl: Response contains List<Proto Invoice>
    deactivate BillingServiceImpl
```

## 5. Technology Stack Summary
- **Framework:** Spring Boot (`spring-boot-starter-web`)
- **Database:** MongoDB (`spring-boot-starter-data-mongodb`)
- **RPC Protocol:** gRPC (`grpc-spring-boot-starter`)
- **Testing:** Karate (`karate-junit5`), Spring Boot Test
- **Build Tool:** Gradle
