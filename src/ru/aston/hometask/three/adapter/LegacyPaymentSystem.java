package ru.aston.hometask.three.adapter;

public class LegacyPaymentSystem {
    public void makePayment(String currency, double value) {
        System.out.println("Processing legacy payment: " + value + " " + currency);
    }

    public boolean checkValidity() {
        System.out.println("Checking validity in legacy system");
        return true;
    }
}