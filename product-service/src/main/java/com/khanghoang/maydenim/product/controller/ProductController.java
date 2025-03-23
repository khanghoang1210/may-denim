package com.khanghoang.maydenim.product.controller;

import com.khanghoang.maydenim.product.dto.ProductReq;
import com.khanghoang.maydenim.product.dto.ProductResponse;
import com.khanghoang.maydenim.product.exception.ExceptionBase;
import com.khanghoang.maydenim.product.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductReq request){
       return productService.createProduct(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductById(@PathVariable String id) throws ExceptionBase {
        return productService.getProductById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse updateProduct(@RequestBody ProductReq request) throws ExceptionBase {
        return productService.updateProduct(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String id) throws ExceptionBase {
        productService.deleteProduct(id);
    }
}
