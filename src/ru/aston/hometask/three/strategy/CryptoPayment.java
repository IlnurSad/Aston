package ru.aston.hometask.three.strategy;

public class CryptoPayment implements PaymentStrategy {
    private final String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Оплачено " + amount + " руб. криптовалютой с кошелька " + walletAddress);
    }
}