package com.mcitmocks.mcitmocks.User;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

  Optional<User> findById(String id);

  Optional<User> findByEmail(String email);
}
