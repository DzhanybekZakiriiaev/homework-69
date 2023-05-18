package com.example.homework69.mapper;


import com.example.homework69.dto.OrderDto;
import com.example.homework69.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {
    public static OrderDto fromOrder(Order order) {
        return OrderDto.builder()
                .orderTime(order.getOrderTime())
                .delivery(order.getDelivery())
                .userEmail(order.getUser().getEmail())
                .price(order.getPrice())
                .productName(List.of(order.getProduct().getName()))
                .productPrice(order.getProduct().getPrice())
                .build();
    }
}
