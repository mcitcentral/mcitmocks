package com.mcitmocks.mcitmocks.User;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

  Optional<User> findById(String id);

  Optional<User> findByEmail(String email);
}

