package com.khanghoang.maydenim.order.service;

import com.khanghoang.maydenim.order.dto.CreateOrderReq;
import com.khanghoang.maydenim.order.enums.OrderStatus;
import com.khanghoang.maydenim.order.enums.PaymentStatus;
import com.khanghoang.maydenim.order.model.Order;
import com.khanghoang.maydenim.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(CreateOrderReq req){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(req.price());
        order.setSkuCode(req.skuCode());
        order.setQuantity(req.quantity());
        order.setStatus(OrderStatus.PENDING);
        order.setPaymentStatus(PaymentStatus.UNPAID);
        order.setShippingAddress(req.shippingAddress());

        orderRepository.save(order);
    }
}
