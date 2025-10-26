package ru.aston.hometask.three.chain_of_responsibility.demo;

import ru.aston.hometask.three.chain_of_responsibility.*;

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        System.out.println("=== Система поддержки ===");
        testSupportSystem();
    }

    private static void testSupportSystem() {
        final Handler technical = new TechnicalSupportHandler();
        final Handler billing = new BillingSupportHandler();
        final Handler manager = new ManagerHandler();
        final Handler general = new GeneralSupportHandler();

        technical.setNext(billing);
        billing.setNext(manager);
        manager.setNext(general);

        final Request techRequest = new Request("technical", "Проблема с программным обеспечением", 1);
        final Request billingRequest = new Request("billing", "Вопрос по оплате", 2);
        final Request urgentRequest = new Request("technical", "Критическая ошибка", 3);
        final Request unknownRequest = new Request("unknown", "Неизвестный запрос", 1);

        technical.handle(techRequest);
        technical.handle(billingRequest);
        technical.handle(urgentRequest);
        technical.handle(unknownRequest);
    }
}