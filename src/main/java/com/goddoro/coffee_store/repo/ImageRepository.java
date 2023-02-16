package com.goddoro.coffee_store.repo;

import com.goddoro.coffee_store.models.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
