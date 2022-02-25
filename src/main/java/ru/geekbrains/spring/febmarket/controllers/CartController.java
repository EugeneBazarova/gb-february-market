package ru.geekbrains.spring.febmarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.febmarket.dtos.Cart;
import ru.geekbrains.spring.febmarket.entities.Product;
import ru.geekbrains.spring.febmarket.services.CartService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }
}
