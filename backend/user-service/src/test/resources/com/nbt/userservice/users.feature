Feature: User Service gRPC Tests

  Background:
    * def Client = Java.type('com.nbt.userservice.client.UserGrpcClient')
    * def client = new Client(grpcHost, grpcPort)
    * def idDoc = '12345678'
    * def randomName = 'User ' + java.util.UUID.randomUUID()

  Scenario: Create and Get User
    # Create User
    * def response = client.createUser(idDoc, randomName, 'test@nbt.com')
    * match response.idDocumento == idDoc
    * match response.nombre == randomName
    
    # Get User
    * def fetchResponse = client.getUser(idDoc)
    * match fetchResponse.idDocumento == idDoc
    * match fetchResponse.nombre == randomName
