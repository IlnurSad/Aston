package ru.aston.hometask.three.decorator.demo;

import ru.aston.hometask.three.decorator.*;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        String message = "Важное сообщение!";

        System.out.println("=== Базовое уведомление ===");
        Notifier basicNotifier = new BasicNotifier();
        basicNotifier.send(message);

        System.out.println("\n=== SMS + Email уведомления ===");
        Notifier smsAndEmailNotifier = new EmailNotifierDecorator(
                new SMSNotifierDecorator(new BasicNotifier())
        );
        smsAndEmailNotifier.send(message);

        System.out.println("\n=== Все виды уведомлений ===");
        Notifier allNotifications = new TelegramNotifierDecorator(
                new VKNotifierDecorator(
                        new EmailNotifierDecorator(
                                new SMSNotifierDecorator(new BasicNotifier())
                        )
                )
        );
        allNotifications.send(message);

        System.out.println("\n=== Кастомная комбинация ===");
        Notifier customNotifier = new TelegramNotifierDecorator(
                new EmailNotifierDecorator(new BasicNotifier())
        );
        customNotifier.send(message);
    }
}