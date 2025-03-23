package com.khanghoang.maydenim.product.service;

import com.khanghoang.maydenim.product.dto.ProductReq;
import com.khanghoang.maydenim.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductReq createProductReq);
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(String id);
    ProductResponse updateProduct(ProductReq updateProductReq);
    void deleteProduct(String id);
}
