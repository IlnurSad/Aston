package ru.aston.hometask.three.strategy;

public class PayPalPayment implements PaymentStrategy {
    private final String email;
    private final String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Оплачено " + amount + " руб. через PayPal аккаунт " + email);
    }
}