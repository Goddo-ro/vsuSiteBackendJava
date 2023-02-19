package com.goddoro.coffee_store.repository;

import com.goddoro.coffee_store.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
