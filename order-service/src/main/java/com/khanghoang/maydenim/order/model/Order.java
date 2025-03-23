package com.khanghoang.maydenim.order.model;

import com.khanghoang.maydenim.order.enums.OrderStatus;
import com.khanghoang.maydenim.order.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID userId;

    private String orderNumber;

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;

    private String shippingAddress;
    private Instant createdAt = Instant.now();
}