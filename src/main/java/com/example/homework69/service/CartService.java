package com.example.homework69.service;

import com.example.homework69.entity.Cart;
import com.example.homework69.entity.Product;
import com.example.homework69.entity.User;
import com.example.homework69.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Cart getCartByUser(User user) {
        return cartRepository.getCartByUser(user);
    }

    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    public void addToCart(Cart cart, Product product) {
        cart.getProducts().add(product);
        cartRepository.save(cart);
    }

    public void removeFromCart(Cart cart, Integer productId) {
        cart.getProducts().removeIf(product -> product.getId().equals(productId));
        cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

    public boolean existsCartByUser(User user) {
        return cartRepository.existsByUser(user);
    }

    public List<Cart> getAllCartsByUser(User user) {
        return cartRepository.findAllByUser(user);
    }

    public long countCarts() {
        return cartRepository.count();
    }

    public void removeFromCart(Cart cart, Long productId) {
        cart.getProducts().removeIf(product -> product.getId().equals(productId));
        cartRepository.save(cart);
    }
}
