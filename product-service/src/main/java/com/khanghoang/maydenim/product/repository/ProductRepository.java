package com.khanghoang.maydenim.product.repository;

import com.khanghoang.maydenim.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
