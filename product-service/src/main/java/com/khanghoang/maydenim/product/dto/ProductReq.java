package com.khanghoang.maydenim.product.dto;

import java.math.BigDecimal;

public record ProductReq(String id, String name, String description, BigDecimal price) {
}
