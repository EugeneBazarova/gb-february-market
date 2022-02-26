package ru.geekbrains.spring.febmarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.febmarket.dtos.Cart;
import ru.geekbrains.spring.febmarket.services.CartService;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteFromCart(@PathVariable Long id) {
        cartService.deleteProductFromCart(id);
    }

    @GetMapping("/clear")
    public void remove() {
        cartService.remove();
    }
}
