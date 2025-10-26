package ru.aston.hometask.three.decorator;

public class VKNotifierDecorator extends NotifierDecorator {
    public VKNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendVKNotification(message);
    }

    private void sendVKNotification(String message) {
        System.out.println("Отправка VK уведомления: " + message);
    }
}