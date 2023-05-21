package com.example.homework69.service;

import com.example.homework69.entity.Cart;
import com.example.homework69.entity.Product;
import com.example.homework69.entity.User;
import com.example.homework69.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Cart getOrCreateCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    public void addToCart(Cart cart, Product product) {
        cart.getProducts().add(product);
        cartRepository.save(cart);
    }

    public void removeFromCart(Cart cart, Long productId) {
        cart.getProducts().removeIf(product -> product.getId().equals(productId));
        cartRepository.save(cart);
    }
}
