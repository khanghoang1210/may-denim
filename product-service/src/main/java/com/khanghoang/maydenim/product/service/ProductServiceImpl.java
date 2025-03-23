package com.khanghoang.maydenim.product.service;

import com.khanghoang.maydenim.product.dto.ProductReq;
import com.khanghoang.maydenim.product.dto.ProductResponse;
import com.khanghoang.maydenim.product.exception.ProductNotFoundException;
import com.khanghoang.maydenim.product.model.Product;
import com.khanghoang.maydenim.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl  implements ProductService{
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductReq createProductReq){
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

    public ProductResponse getProductById(String id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice()
        );

    }

    public ProductResponse updateProduct(ProductReq updateProductReq) {
        Product product = productRepository.findById(updateProductReq.id())
                .orElseThrow(() -> new ProductNotFoundException());

        product.setName(updateProductReq.name());
        product.setPrice(updateProductReq.price());
        product.setDescription(updateProductReq.description());
        Product updatedProduct = productRepository.save(product);

        return new ProductResponse(
                updatedProduct.getId(),
                updatedProduct.getName(),
                updatedProduct.getDescription(),
                updatedProduct.getPrice()
        );
    }

    public void deleteProduct(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException());
        productRepository.deleteById(product.getId());
    }
}
