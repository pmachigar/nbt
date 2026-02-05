package com.nbt.userservice.repository;

import com.nbt.userservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByIdDocumento(String idDocumento);

    void deleteByIdDocumento(String idDocumento);
}
