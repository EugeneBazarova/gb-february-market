package ru.geekbrains.spring.febmarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Long productId;
    private String productTitle;
    private String productInfo;
    private int quantity;
    private int pricePerProduct;
    private int price;
}

