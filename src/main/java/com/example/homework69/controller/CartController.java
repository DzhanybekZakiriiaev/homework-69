package com.example.homework69.controller;

import com.example.homework69.entity.Cart;
import com.example.homework69.entity.Order;
import com.example.homework69.entity.Product;
import com.example.homework69.entity.User;
import com.example.homework69.service.CartService;
import com.example.homework69.service.OrderService;
import com.example.homework69.service.ProductService;
import com.example.homework69.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
    private final ProductService productService;

    private final OrderService orderService;
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

    @PostMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable Long productId, HttpSession session) {
        Cart cart = cartService.getOrCreateCart(session);
        cartService.removeFromCart(cart, productId);
        return "redirect:/cart/view";
    }

    @PostMapping("/place-order")
    public String placeOrder(HttpSession session, @RequestParam String delivery) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            User user = (User) session.getAttribute("user");
            Order order = Order.builder()
                    .delivery(delivery)
                    .price(cart.getProducts().stream()
                            .mapToInt(Product::getPrice)
                            .sum())
                    .orderTime(LocalDateTime.now())
                    .user(user)
                    .products(cart.getProducts())
                    .build();
            orderService.save(order);
            session.removeAttribute("cart");
            return "redirect:/cart/view";
        }
        return "redirect:/cart/view";
    }

}
