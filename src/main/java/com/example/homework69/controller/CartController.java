package com.example.homework69.controller;

import com.example.homework69.entity.Cart;
import com.example.homework69.entity.Product;
import com.example.homework69.entity.User;
import com.example.homework69.service.CartService;
import com.example.homework69.service.ProductService;
import com.example.homework69.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
    private final ProductService productService;

    private final UserService userService;
    private final CartService cartService;

    @GetMapping("/view")
    public String viewCart(Model model, HttpSession session) {
        Cart cart = cartService.getOrCreateCart(session);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable Long productId, HttpSession session) {
        Optional<Product> optionalProduct = productService.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            Cart cart = cartService.getOrCreateCart(session);
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            cartService.addToCart(cart, product);
        }
        return "redirect:/cart/view";
    }

}
