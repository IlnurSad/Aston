package ru.aston.hometask.three.decorator;

public class BasicNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Отправка базового уведомления: " + message);
    }
}