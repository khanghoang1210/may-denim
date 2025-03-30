package com.khanghoang.maydenim.order.service;

import com.khanghoang.maydenim.order.dto.CreateOrderReq;
import com.khanghoang.maydenim.order.dto.OrderResponse;
import com.khanghoang.maydenim.order.enums.OrderStatus;
import com.khanghoang.maydenim.order.enums.PaymentStatus;
import com.khanghoang.maydenim.order.model.Order;
import com.khanghoang.maydenim.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
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

    @Override
    public List<OrderResponse> getOrdersByUser(Long userId) {
        List<Order> order = orderRepository.findByUserId(userId);
        return order.stream()
                .map(o -> new OrderResponse(o.getId(),
                        o.getOrderNumber(),
                        o.getSkuCode(), o.getPrice(),
                         o.getQuantity(), o.getShippingAddress()))
                .toList();
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(()->new RuntimeException());
        return new OrderResponse(
                order.getId(),
                order.getOrderNumber(),
                order.getSkuCode(),
                order.getPrice(),
                order.getQuantity(),
                order.getShippingAddress()
        );
    }

    @Override
    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException());
        order.setStatus(OrderStatus.CANCELLED);
        orderRepository.save(order);
    }
}
