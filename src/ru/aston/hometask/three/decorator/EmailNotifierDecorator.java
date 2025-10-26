package ru.aston.hometask.three.decorator;

public class EmailNotifierDecorator extends NotifierDecorator {
    public EmailNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendEmail(message);
    }

    private void sendEmail(String message) {
        System.out.println("Отправка Email: " + message);
    }
}