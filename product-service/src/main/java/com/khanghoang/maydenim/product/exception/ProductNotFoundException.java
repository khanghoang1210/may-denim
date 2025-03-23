package com.khanghoang.maydenim.product.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends ExceptionBase {
    public ProductNotFoundException() {
        super();
        this.code = "1";
        this.msg = "Không tìm thấy sản phẩm";
        this.status = HttpStatus.NOT_FOUND;

    }
}
