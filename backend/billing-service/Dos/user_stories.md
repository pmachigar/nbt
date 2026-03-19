# Billing Service User Stories

Based on the implemented features in `BillingServiceImpl.java`, `Invoice.java`, and `BillingRepository.java`, here are the User Stories that capture the essence of the codebase.

## Feature 1: Automated Invoice Generation (`generateInvoice`)

> **US01: Trigger Automated Billing for Subscriptions**
> **As an** internal system (e.g., Subscription or Scheduler Service),  
> **I want to** trigger the generation of an invoice for a specific user and their active subscriptions,  
> **So that** the user's billing cycle is automatically processed and recorded.
> 
> *Acceptance Criteria (from code context):*
> - The request must include the `userId` and a list of `subscriptionIds`.
> - A new `Invoice` document must be created and persisted in the `billing-db` MongoDB instance.
> - The invoice status defaults to `PENDING`.
> - The system returns the generated invoice ID and total amount via a gRPC response.

> **US02: Itemized Invoice Breakdown**
> **As an** end-user,  
> **I want to** see an itemized breakdown of my charges on the generated invoice,  
> **So that** I understand exactly what subscription services I am paying for.
> 
> *Acceptance Criteria (from code context):*
> - For every subscription ID provided, an `InvoiceItem` must be attached to the invoice.
> - Each item must include a description ("Service Charge for Subscription [ID]"), a quantity, and a computed amount.
> - The overall Invoice must accurately sum the `totalValue` across all items generated.

## Feature 2: Invoice History Retrieval (`getInvoices`)

> **US03: View Personal Invoice History**
> **As an** end-user,  
> **I want to** retrieve a complete list of all my invoices,  
> **So that** I can review past payments and check my current pending balance.
> 
> *Acceptance Criteria (from code context):*
> - The request must supply a valid `userId`.
> - The service queries MongoDB (`BillingRepository.findByUserId()`) to retrieve all historical invoices matching the user.
> - The system returns a serialized list of invoices (including issue dates, status, and itemized lines) through the gRPC endpoint.

> **US04: Access User Billing Records for Support**
> **As an** administrator or customer support agent,  
> **I want to** query the billing service for a specific tenant's/user's invoices,  
> **So that** I can support users with billing disputes or payment history reviews.
> 
> *Acceptance Criteria (from code context):*
> - Leverages the same `getInvoices` endpoint.
> - Must return all invoices irrespective of whether they are `PENDING` or already `PAID`.
