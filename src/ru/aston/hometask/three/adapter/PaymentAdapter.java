package ru.aston.hometask.three.adapter;

public class PaymentAdapter implements PaymentProcessor {
    private static final String CURRENCY_USD = "USD";
    private final LegacyPaymentSystem legacySystem;

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