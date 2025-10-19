package ru.aston.hometask.three.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<String> items;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Не выбрана стратегия оплаты!");
            return;
        }

        System.out.println("Оформление заказа:");
        for (String item : items) {
            System.out.println(" - " + item);
        }

        paymentStrategy.pay(amount);
        items.clear();
    }
}