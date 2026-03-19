# Abrechnungsservice-Dokumentation

## 1. Überblick
Der **Abrechnungsservice (Billing Service)** ist ein Spring-Boot-basierter Microservice, der für die Generierung und Verwaltung von Benutzerrechnungen zuständig ist. Er nutzt **MongoDB** zur dauerhaften Speicherung und stellt seine Operationen über **gRPC** bereit, um eine hochleistungsfähige, stark typisierte Kommunikation mit anderen Microservices im Ökosystem sicherzustellen.

## 2. Systemarchitektur

Der Service folgt einem typischen Schichtenarchitektur-Muster, das mit gRPC integriert ist:

```mermaid
graph TD
    Client["Client-Services (z. B. API Gateway, Abonnement-Service)"] -- gRPC (Port 9094) --> gRPC_Server["BillingServiceGrpc Server"]
    gRPC_Server --> Service["BillingServiceImpl"]
    Service --> Repository["BillingRepository (Spring Data MongoDB)"]
    Repository -- MongoDB Protocol (Port 27017) --> DB[(MongoDB: billing-db)]
    
    subgraph Spring Boot Anwendung
        gRPC_Server
        Service
        Repository
        Domain["Domänenmodell (Rechnung/Invoice)"]
    end
```

### Hauptkomponenten:
- **`BillingServiceImpl`**: Die zentrale `@GrpcService`-Klasse, die eingehende Anfragen verarbeitet.
- **`BillingRepository`**: Schnittstelle, die `MongoRepository` erweitert und Datenbankoperationen abwickelt.
- **`proto-common`**: Externes gemeinsames Modul, in dem die Protobuf-Deskriptoren (`BillingServiceGrpc`, `Invoice` usw.) definiert sind.

## 3. Domänenmodell

Die Servicedomäne besteht aus einem Hauptdokument `Invoice` (Rechnung), in das mehrere Sub-Dokumente vom Typ `InvoiceItem` (Rechnungsposten) eingebettet sind.

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
    
    Invoice "1" *-- "*" InvoiceItem : enthält
```

- **`status`**: Kann `PENDING` (Ausstehend) oder `PAID` (Bezahlt) sein.
- **`items`**: Stellt individuelle Rechnungsposten für die in Rechnung gestellten Dienste dar.

## 4. gRPC-Workflows

Der Service stellt die folgenden Haupteinstiegspunkte bereit. Nachfolgend finden Sie Sequenzdiagramme, die ihr Verhalten veranschaulichen.

### 4.1. Generieren einer Rechnung (`generateInvoice`)
Wenn ein aufrufender Service die Rechnungsgenerierung anfordert, erstellt der Abrechnungsservice derzeit Dummy-Rechnungsposten basierend auf den bereitgestellten Abonnement-IDs und speichert die neue Rechnung ab.

```mermaid
sequenceDiagram
    participant Client
    participant BillingServiceImpl
    participant MongoDB
    
    Client->>BillingServiceImpl: generateInvoice(GenerateInvoiceRequest)
    Note over Client,BillingServiceImpl: Anfrage enthält userId und List<SubscriptionId>
    
    activate BillingServiceImpl
    BillingServiceImpl->>BillingServiceImpl: Initialisiere neue Rechnung (Status: PENDING)
    
    loop Für jede SubscriptionId
        BillingServiceImpl->>BillingServiceImpl: Generiere Dummy-InvoiceItem
        BillingServiceImpl->>BillingServiceImpl: Berechne Zwischensumme (totalValue)
    end
    
    BillingServiceImpl->>MongoDB: save(Invoice)
    MongoDB-->>BillingServiceImpl: Gespeicherte Rechnung (mit generierter ID)
    
    BillingServiceImpl->>BillingServiceImpl: toProto(savedInvoice)
    Note over BillingServiceImpl,Client: Mappt internes Modell auf gRPC Protobuf
    
    BillingServiceImpl-->>Client: onNext(Proto Invoice) & onCompleted()
    deactivate BillingServiceImpl
```

### 4.2. Abrufen von Benutzerrechnungen (`getInvoices`)
Ermöglicht das Abrufen des kompletten Rechnungsverlaufs für einen bestimmten Benutzer.

```mermaid
sequenceDiagram
    participant Client
    participant BillingServiceImpl
    participant MongoDB
    
    Client->>BillingServiceImpl: getInvoices(GetInvoicesRequest)
    Note over Client,BillingServiceImpl: Anfrage enthält userId
    
    activate BillingServiceImpl
    BillingServiceImpl->>MongoDB: findByUserId(userId)
    MongoDB-->>BillingServiceImpl: List<Invoice> (Domänenobjekte)
    
    loop Für jede Domänenrechnung
        BillingServiceImpl->>BillingServiceImpl: toProto(invoice)
    end
    
    BillingServiceImpl-->>Client: onNext(GetInvoicesResponse) & onCompleted()
    Note over Client,BillingServiceImpl: Antwort enthält List<Proto Invoice>
    deactivate BillingServiceImpl
```

## 5. Zusammenfassung des Technologie-Stacks
- **Framework:** Spring Boot (`spring-boot-starter-web`)
- **Datenbank:** MongoDB (`spring-boot-starter-data-mongodb`)
- **RPC Protokoll:** gRPC (`grpc-spring-boot-starter`)
- **Tests:** Karate (`karate-junit5`), Spring Boot Test
- **Build-Tool:** Gradle
