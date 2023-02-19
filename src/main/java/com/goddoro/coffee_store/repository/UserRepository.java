package com.goddoro.coffee_store.repository;

import com.goddoro.coffee_store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
