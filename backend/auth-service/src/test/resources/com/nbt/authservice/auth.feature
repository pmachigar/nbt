Feature: Auth Service Tests

  Background:
    * def Client = Java.type('com.nbt.authservice.client.AuthGrpcClient')
    * def client = new Client(grpcHost, grpcPort)
    # Note: Requires user to exist in DB. 
    # In integration test, we might need to seed DB or create user via User Service first, 
    # but Auth Service has its own DB. 
    # For now assuming 'admin' exists or we fail. 
    # To make this robust, we would inject a user into Mongo first.

  Scenario: Login Failure with invalid credentials
    # Trying to login with non-existent user
    * def result = karate.call(function(){ try { return client.login('nonexistent', 'pass'); } catch(e) { return { error: e.message }; } })
    * match result.error contains 'User not found'

  # Note: Successful login requires seeding the DB which we can do via a Java helper or Karate-Mongo interop if needed.
  # For now, this test checks the negative case which proves gRPC connectivity.
