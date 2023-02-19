package com.goddoro.coffee_store.repo;

import com.goddoro.coffee_store.entity.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
