Feature: Catalog Service Tests

  Background:
    * def Client = Java.type('com.nbt.catalogservice.client.CatalogGrpcClient')
    * def client = new Client('localhost', 9092)

  Scenario: Create and List Services
    * def desc = 'Internet 100MB'
    * def rate = 30.0
    * def created = client.createService(desc, rate, 'MONTH')
    * match created.description == desc
    * match created.rate == rate

    * def list = client.listServices()
    * assert list.servicesCount > 0
