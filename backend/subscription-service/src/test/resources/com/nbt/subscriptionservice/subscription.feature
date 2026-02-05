Feature: Subscription Service Tests

  Background:
    * def Client = Java.type('com.nbt.subscriptionservice.client.SubscriptionGrpcClient')
    * def client = new Client('localhost', 9093)

  Scenario: Subscribe User
    * def userId = 'user-123'
    * def serviceId = 'service-555'
    * def subscription = client.subscribe(userId, serviceId)
    * match subscription.status == 'ACTIVE'
    * match subscription.userId == userId
