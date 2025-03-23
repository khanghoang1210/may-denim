package com.khanghoang.maydenim.product.service;

import com.khanghoang.maydenim.product.dto.CreateProductReq;
import com.khanghoang.maydenim.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(CreateProductReq createProductReq);
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(String id);
}
