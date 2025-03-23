package com.khanghoang.maydenim.order.dto;

import java.math.BigDecimal;

public record CreateOrderReq(Long id, String orderNumber, String skuCode, BigDecimal price, Integer quantity, String shippingAddress) {
}
