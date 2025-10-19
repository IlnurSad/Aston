package ru.aston.hometask.three.adapter.demo;

import ru.aston.hometask.three.adapter.LegacyPaymentSystem;
import ru.aston.hometask.three.adapter.PaymentAdapter;
import ru.aston.hometask.three.adapter.PaymentProcessor;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        LegacyPaymentSystem legacySystem = new LegacyPaymentSystem();
        PaymentProcessor processor = new PaymentAdapter(legacySystem);
        
        processor.validate();
        processor.processPayment(100.50);
    }
}