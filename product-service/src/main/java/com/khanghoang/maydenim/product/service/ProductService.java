package com.khanghoang.maydenim.product.service;

import com.khanghoang.maydenim.product.dto.CreateProductReq;
import com.khanghoang.maydenim.product.dto.ProductResponse;
import com.khanghoang.maydenim.product.model.Product;
import com.khanghoang.maydenim.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(CreateProductReq createProductReq){
        Product product = Product.builder()
                .name(createProductReq.name())
                .description(createProductReq.description())
                .price(createProductReq.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
