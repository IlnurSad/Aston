package ru.aston.hometask.three.adapter;

public class PaymentAdapter implements PaymentProcessor {
    private final LegacyPaymentSystem legacySystem;
    private static final String CURRENCY_USD = "USD";

    public PaymentAdapter(LegacyPaymentSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void processPayment(double amount) {
        legacySystem.makePayment(CURRENCY_USD, amount);
    }

    @Override
    public boolean validate() {
        return legacySystem.checkValidity();
    }
}