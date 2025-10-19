package ru.aston.hometask.three.adapter;

public interface PaymentProcessor {
    void processPayment(double amount);
    boolean validate();
}