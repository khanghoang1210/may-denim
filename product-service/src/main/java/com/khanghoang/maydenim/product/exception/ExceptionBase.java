package com.khanghoang.maydenim.product.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionBase extends RuntimeException{
    protected String code;
    protected String msg;
    protected HttpStatus status;
}
