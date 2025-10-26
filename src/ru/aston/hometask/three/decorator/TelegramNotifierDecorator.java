package ru.aston.hometask.three.decorator;

public class TelegramNotifierDecorator extends NotifierDecorator {
    public TelegramNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendTelegramMessage(message);
    }

    private void sendTelegramMessage(String message) {
        System.out.println("Отправка Telegram сообщения: " + message);
    }
}