package com.nbt.authservice;

import com.intuit.karate.junit5.Karate;
import net.devh.boot.grpc.server.config.GrpcServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, properties = "grpc.server.port=0")
class KarateTests {

    @Autowired
    private GrpcServerProperties grpcServerProperties;

    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass()).systemProperty("grpc.port",
                String.valueOf(grpcServerProperties.getPort()));
    }
}
