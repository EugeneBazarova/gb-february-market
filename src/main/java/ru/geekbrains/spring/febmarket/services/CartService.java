package ru.geekbrains.spring.febmarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.febmarket.dtos.Cart;
import ru.geekbrains.spring.febmarket.entities.Product;
import ru.geekbrains.spring.febmarket.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring.febmarket.repositories.ProductRepository;


import javax.annotation.PostConstruct;


@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private final ProductRepository productRepository;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart() {
        return tempCart;
    }

    public void add(Long productId) {
        Product product = productService.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Не удается добавить продукт с id: " + productId + " в корзину. Продукт не найден"));
        tempCart.add(product);
    }

//    public void deleteProductFromCart(Long productId){
//        Product product = productRepository.findById(productId).get();
//        tempCart.deleteFromCart(product);
//    }

    public void deleteProductFromCart(Long productId) {
        Product product = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Не удается найти продукт с id: " + productId));
        tempCart.deleteProductFromCart(product);
    }

    public void remove() {
        tempCart.remove();
    }

}
