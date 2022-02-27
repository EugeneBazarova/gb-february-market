package ru.geekbrains.spring.febmarket.model;

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
        for (CartItem item : items) {
            if (product.getId().equals(item.getProductId())) {
                item.quantityCount(1);
                recalculate();
                return;
            }
        }
        items.add(new CartItem(product.getId(), product.getTitle(), product.getInfo(), 1, product.getPrice(), product.getPrice()));
        recalculate();
    }

    private void recalculate() {
        totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getPrice();
        }
    }

    private CartItem findItemFromCart(Product product) {
        return items.stream().filter(o -> o.getProductId().equals(product.getId())).findFirst().orElse(null);
    }

    public void removeOneItem(Product product) {
        for (CartItem item : items) {
            if (product.getId().equals(item.getProductId())) {
                item.quantityCount(-1);
                recalculate();
                return;
            }
        }
        recalculate();
    }

    public void deleteProductFromCart(Product product) {
        CartItem item = findItemFromCart(product);
        if (item == null) {
            return;
        }
        items.remove(item);
        recalculate();
    }

    public void remove() {
        items.clear();
        recalculate();
    }
}
