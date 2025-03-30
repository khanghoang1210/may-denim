package com.khanghoang.maydenim.order.controller;

import com.khanghoang.maydenim.order.dto.CreateOrderReq;
import com.khanghoang.maydenim.order.dto.OrderResponse;
import com.khanghoang.maydenim.order.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceImpl orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody CreateOrderReq req){
        orderService.placeOrder(req);
        return "Order Place Successfully";
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getByUserId(@PathVariable Long userId){
        return orderService.getOrdersByUser(userId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}/cancel")
    @ResponseStatus(HttpStatus.CREATED)
    public void cancelOrder(@PathVariable Long id){
        orderService.cancelOrder(id);
    }
}
