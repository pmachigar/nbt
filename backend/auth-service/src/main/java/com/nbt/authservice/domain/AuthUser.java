package com.nbt.authservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "auth_users")
public class AuthUser {
    @Id
    private String id;
    private String username;
    private String password; // BCrypt Encoded
    private String userId; // Reference to User Service ID
    private String twoFactorSecret;
    private boolean isMfaEnabled;
}
