package ru.geekbrains.spring.febmarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.febmarket.entities.Product;
import ru.geekbrains.spring.febmarket.services.CartService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<Product> findAllInCart() {
        return cartService.findAllProductsInCart();
    }

    @GetMapping("/addproduct/{productId}")
    public List<Product> addToCart(@PathVariable Long productId) {
        cartService.addProductToCart(productId);
        return cartService.findAllProductsInCart();
    }

    @DeleteMapping("/deleteproduct/{productId}")
    public void deleteFromCart(@PathVariable Long productId) {
        cartService.deleteProductFromCart(productId);
    }
}