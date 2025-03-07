package com.khanghoang.maydenim.order.repository;

import com.khanghoang.maydenim.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
