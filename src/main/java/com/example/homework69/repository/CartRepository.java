package com.example.homework69.repository;

import com.example.homework69.entity.Cart;
import com.example.homework69.entity.Product;
import com.example.homework69.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart getCartByUser(User user);

    List<Cart> findAll();

    Optional<Cart> findById(Long id);

    Cart save(Cart cart);

    void delete(Cart cart);

    boolean existsByUser(User user);

    List<Cart> findAllByUser(User user);
}

