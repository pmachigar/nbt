# Historias de Usuario del Servicio de Facturación

Basado en las características implementadas en `BillingServiceImpl.java`, `Invoice.java` y `BillingRepository.java`, aquí están las Historias de Usuario que capturan la esencia del código base.

## Característica 1: Generación Automatizada de Facturas (`generateInvoice`)

> **US01: Activar Facturación Automática para Suscripciones**
> **Como** sistema interno (ej. Servicio de Suscripciones o Programador/Scheduler),  
> **Quiero** activar la generación de una factura para un usuario específico y sus suscripciones activas,  
> **Para que** el ciclo de facturación del usuario se procese y registre automáticamente.
> 
> *Criterios de Aceptación (del contexto del código):*
> - La petición debe incluir el `userId` y una lista de `subscriptionIds`.
> - Un nuevo documento `Invoice` debe crearse y persistirse en la instancia MongoDB `billing-db`.
> - El estado de la factura es `PENDING` por defecto.
> - El sistema devuelve el ID de la factura generada y el importe total a través de una respuesta gRPC.

> **US02: Desglose Detallado de Factura**
> **Como** usuario final,  
> **Quiero** ver un desglose detallado de mis cargos en la factura generada,  
> **Para que** pueda entender exactamente qué servicios de suscripción estoy pagando.
> 
> *Criterios de Aceptación (del contexto del código):*
> - Por cada ID de suscripción proporcionado, un `InvoiceItem` debe adjuntarse a la factura.
> - Cada ítem debe incluir una descripción ("Service Charge for Subscription [ID]"), una cantidad y un monto calculado.
> - La factura general (Invoice) debe sumar con precisión el `totalValue` de todos los ítems generados.

## Característica 2: Recuperación de Historial de Facturas (`getInvoices`)

> **US03: Ver Historial Personal de Facturas**
> **Como** usuario final,  
> **Quiero** obtener una lista completa de todas mis facturas,  
> **Para que** pueda revisar pagos pasados y verificar mi saldo pendiente actual.
> 
> *Criterios de Aceptación (del contexto del código):*
> - La petición debe suministrar un `userId` válido.
> - El servicio consulta MongoDB (`BillingRepository.findByUserId()`) para recuperar todas las facturas históricas que coincidan con el usuario.
> - El sistema devuelve una lista serializada de facturas (incluyendo fechas de emisión, estado y líneas de ítems) a través del endpoint gRPC.

> **US04: Acceder a Registros de Facturación para Soporte**
> **Como** administrador o agente de atención al cliente,  
> **Quiero** consultar en el servicio de facturación las facturas de un inquilino/usuario específico,  
> **Para que** pueda apoyar a los usuarios con disputas de facturación o revisiones del historial de pagos.
> 
> *Criterios de Aceptación (del contexto del código):*
> - Utiliza el mismo endpoint `getInvoices`.
> - Debe devolver todas las facturas independientemente de si están en estado `PENDING` o ya están `PAID`.
