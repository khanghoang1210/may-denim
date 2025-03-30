package com.khanghoang.maydenim.order.service;

import com.khanghoang.maydenim.order.dto.CreateOrderReq;
import com.khanghoang.maydenim.order.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    void placeOrder(CreateOrderReq req);
    List<OrderResponse> getOrdersByUser(Long userId);
    OrderResponse getOrderById(Long id);
    void cancelOrder(Long id);
}
