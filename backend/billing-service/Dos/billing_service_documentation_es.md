# Documentación del Servicio de Facturación

## 1. Descripción General
El **Servicio de Facturación (Billing Service)** es un microservicio basado en Spring Boot responsable de generar y gestionar las facturas de los usuarios. Utiliza **MongoDB** para el almacenamiento persistente y expone sus operaciones a través de **gRPC** para asegurar una comunicación de alto rendimiento y tipado fuerte con otros microservicios en el ecosistema.

## 2. Arquitectura del Sistema

El servicio sigue un patrón de arquitectura en capas estándar integrado con gRPC:

```mermaid
graph TD
    Client["Servicios de Cliente (ej. API Gateway, Servicio de Suscripciones)"] -- gRPC (Puerto 9094) --> gRPC_Server["Servidor BillingServiceGrpc"]
    gRPC_Server --> Service["BillingServiceImpl"]
    Service --> Repository["BillingRepository (Spring Data MongoDB)"]
    Repository -- Protocolo MongoDB (Puerto 27017) --> DB[(MongoDB: billing-db)]
    
    subgraph Aplicación Spring Boot
        gRPC_Server
        Service
        Repository
        Domain["Modelo de Dominio (Factura/Invoice)"]
    end
```

### Componentes Principales:
- **`BillingServiceImpl`**: La clase principal `@GrpcService` que procesa las solicitudes entrantes.
- **`BillingRepository`**: Interfaz que extiende `MongoRepository` y maneja las operaciones de base de datos.
- **`proto-common`**: Módulo compartido externo donde se definen los descriptores de Protobuf (`BillingServiceGrpc`, `Invoice`, etc.).

## 3. Modelo de Dominio

El dominio del servicio consiste en un documento principal `Invoice` (Factura) que incrusta múltiples sub-documentos `InvoiceItem` (Ítem de Factura).

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
    
    Invoice "1" *-- "*" InvoiceItem : contiene
```

- **`status`**: Puede ser `PENDING` (Pendiente) o `PAID` (Pagada).
- **`items`**: Representa los conceptos individuales que se están facturando.

## 4. Flujos de Trabajo gRPC

El servicio expone los siguientes puntos de entrada principales. A continuación, los diagramas de secuencia que ilustran su comportamiento.

### 4.1. Generar una Factura (`generateInvoice`)
Cuando un servicio solicitante pide la generación de una factura, el Servicio de Facturación actualmente crea ítems de factura simulados (mock) basados en los IDs de suscripción proporcionados y persiste la nueva factura.

```mermaid
sequenceDiagram
    participant Client
    participant BillingServiceImpl
    participant MongoDB
    
    Client->>BillingServiceImpl: generateInvoice(GenerateInvoiceRequest)
    Note over Client,BillingServiceImpl: La petición incluye userId y List<SubscriptionId>
    
    activate BillingServiceImpl
    BillingServiceImpl->>BillingServiceImpl: Inicializar nueva Factura (estado: PENDING)
    
    loop Por cada SubscriptionId
        BillingServiceImpl->>BillingServiceImpl: Generar InvoiceItem simulado
        BillingServiceImpl->>BillingServiceImpl: Calcular totalValue acumulado
    end
    
    BillingServiceImpl->>MongoDB: save(Invoice)
    MongoDB-->>BillingServiceImpl: Factura Guardada (con ID generado)
    
    BillingServiceImpl->>BillingServiceImpl: toProto(savedInvoice)
    Note over BillingServiceImpl,Client: Mapea dominio interno a Protobuf de gRPC
    
    BillingServiceImpl-->>Client: onNext(Proto Invoice) y onCompleted()
    deactivate BillingServiceImpl
```

### 4.2. Recuperar Facturas de Usuario (`getInvoices`)
Permite recuperar el historial completo de facturas para un usuario determinado.

```mermaid
sequenceDiagram
    participant Client
    participant BillingServiceImpl
    participant MongoDB
    
    Client->>BillingServiceImpl: getInvoices(GetInvoicesRequest)
    Note over Client,BillingServiceImpl: La petición incluye userId
    
    activate BillingServiceImpl
    BillingServiceImpl->>MongoDB: findByUserId(userId)
    MongoDB-->>BillingServiceImpl: List<Invoice> (Objetos de dominio)
    
    loop Por cada Factura de Dominio
        BillingServiceImpl->>BillingServiceImpl: toProto(invoice)
    end
    
    BillingServiceImpl-->>Client: onNext(GetInvoicesResponse) y onCompleted()
    Note over Client,BillingServiceImpl: La respuesta contiene List<Proto Invoice>
    deactivate BillingServiceImpl
```

## 5. Resumen del Stack Tecnológico
- **Framework:** Spring Boot (`spring-boot-starter-web`)
- **Base de Datos:** MongoDB (`spring-boot-starter-data-mongodb`)
- **Protocolo RPC:** gRPC (`grpc-spring-boot-starter`)
- **Pruebas:** Karate (`karate-junit5`), Spring Boot Test
- **Herramienta de Construcción:** Gradle
