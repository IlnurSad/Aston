package ru.aston.hometask.three.strategy.demo;

import ru.aston.hometask.three.strategy.CreditCardPayment;
import ru.aston.hometask.three.strategy.CryptoPayment;
import ru.aston.hometask.three.strategy.PayPalPayment;
import ru.aston.hometask.three.strategy.ShoppingCart;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Ноутбук");
        cart.addItem("Мышь");
        cart.addItem("Клавиатура");

        cart.setPaymentStrategy(new CreditCardPayment(
                "1234-5678-9012-3456",
                "Иван Иванов",
                "123",
                "12/25"
        ));
        cart.checkout(150000);

        System.out.println();

        cart.addItem("Наушники");
        cart.addItem("Веб-камера");

        cart.setPaymentStrategy(new PayPalPayment(
                "user@example.com",
                "password123"
        ));
        cart.checkout(25000);

        System.out.println();

        cart.addItem("Монитор");

        cart.setPaymentStrategy(new CryptoPayment(
                "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"
        ));
        cart.checkout(50000);
    }
}