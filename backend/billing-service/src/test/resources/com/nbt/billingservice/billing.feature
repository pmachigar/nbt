Feature: Billing Service Tests

  Background:
    * def Client = Java.type('com.nbt.billingservice.client.BillingGrpcClient')
    * def client = new Client('localhost', 9094)
    * def Arrays = Java.type('java.util.Arrays')

  Scenario: Generate Invoice
    * def userId = 'user-bill-1'
    * def subList = Arrays.asList('sub-1', 'sub-2')
    * def invoice = client.generateInvoice(userId, subList)
    * match invoice.itemsCount == 2
    * match invoice.status == 'PENDING'
