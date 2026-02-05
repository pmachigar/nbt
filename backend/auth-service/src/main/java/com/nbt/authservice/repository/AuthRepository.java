package com.nbt.authservice.repository;

import com.nbt.authservice.domain.AuthUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends MongoRepository<AuthUser, String> {
    Optional<AuthUser> findByUsername(String username);
}
