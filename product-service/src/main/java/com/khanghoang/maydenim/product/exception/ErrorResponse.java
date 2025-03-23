package com.khanghoang.maydenim.product.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse{
    private int httpCode;
    private String errorCode;
    private String message;

    public ErrorResponse(ExceptionBase exception)
    {
        this.httpCode = exception.status.value();
        this.errorCode = exception.getCode();
        this.message = exception.getMsg();
    }
}