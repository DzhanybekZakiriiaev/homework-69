package com.example.homework69.service;

import com.example.homework69.entity.Order;
import com.example.homework69.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    final private OrderRepository orderRepository;

    public List<Order> getOrdersByIdUser(Integer id) {
        return orderRepository.getOrdersByIdUser(id);
    }

    public Order save(Order order){return orderRepository.save(order);}
}
