package com.goddoro.coffee_store.repo;

import com.goddoro.coffee_store.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
