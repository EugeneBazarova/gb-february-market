package ru.geekbrains.spring.febmarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.febmarket.dtos.Cart;
import ru.geekbrains.spring.febmarket.entities.Product;
import ru.geekbrains.spring.febmarket.repositories.ProductRepository;


import java.util.List;


@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductRepository productRepository;

    private final Cart cart;

    public List<Product> findAllProductsInCart() {
        return cart.getProducts();
    }

    public void addProductToCart(Long productId){
        Product product = productRepository.findById(productId).get();
        cart.addProductToCart(product);
    }

    public void deleteProductFromCart(Long productId){
        Product product = productRepository.findById(productId).get();
        cart.deleteProductFromCart(product);
    }
}
