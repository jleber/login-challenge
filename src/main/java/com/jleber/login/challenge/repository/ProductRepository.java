package com.jleber.login.challenge.repository;

import com.jleber.login.challenge.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Stream<Product> findAllByType(String type);

}
