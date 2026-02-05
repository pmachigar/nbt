package com.nbt.userservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String idDocumento;
    private String nombre;
    private Address direccion;
    private Contact contacto;

    @Data
    public static class Address {
        private String pais;
        private String ciudad;
        private String region;
        private String comuna;
        private String calle;
        private String numero;
        private String piso;
        private String apartamento;
        private String block;
        private String zona;
    }

    @Data
    public static class Contact {
        private String telefono;
        private String email;
        private String instagram;
        private String facebook;
    }
}
