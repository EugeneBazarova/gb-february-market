package ru.geekbrains.spring.febmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FebMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(FebMarketApplication.class, args);
	}
}

// Домашнее задание:
// 1. Группировка продуктов в корзине
// 2. Добавляете возможно по кнопке на фронте очищать корзину
// 3. * Добавьте возможность увеличивать/уменьшать кол-во товаров в одной "продуктовой строке" корзины
// 4. * Добавьте возможность удалять "продуктовую строку" корзины