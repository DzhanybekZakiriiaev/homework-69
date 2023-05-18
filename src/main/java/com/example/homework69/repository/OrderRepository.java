package com.example.homework69.repository;


import com.example.homework69.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select o from Order as o where o.user.id = :id")
    List<Order> getOrdersByIdUser(Integer id);
}
