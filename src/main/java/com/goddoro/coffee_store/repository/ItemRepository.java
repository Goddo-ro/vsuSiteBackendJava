package com.goddoro.coffee_store.repository;

import com.goddoro.coffee_store.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
