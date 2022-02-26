package ru.geekbrains.spring.febmarket.dtos;

import lombok.Data;
import ru.geekbrains.spring.febmarket.entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Data
public class Cart {
    private List<CartItem> items;
    private int totalPrice;


    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(Product product) {
        items.add(new CartItem(product.getId(), product.getTitle(), product.getInfo(), 1, product.getPrice(), product.getPrice()));
        recalculate();
    }

    public void deleteFromCart(Product product) {
        items.remove(product);
    }


    private void recalculate() {
        totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getPrice();
        }
    }

    public void remove() {
        items.clear();
        recalculate();
    }


}