package ru.geekbrains.spring.febmarket.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.febmarket.entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@Data
@NoArgsConstructor
public class Cart {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>();
    }

    public void addProductToCart(Product product) {
        products.add(product);
    }

    public void deleteProductFromCart(Product product) {
        products.remove(product);
    }
}