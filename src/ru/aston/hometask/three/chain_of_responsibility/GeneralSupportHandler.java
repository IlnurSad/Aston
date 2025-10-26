package ru.aston.hometask.three.chain_of_responsibility;

public class GeneralSupportHandler extends AbstractHandler {

    @Override
    public void handle(Request request) {
        if (canHandle(request)) {
            System.out.println("Общая поддержка обрабатывает запрос: " + request.getContent());
        } else {
            System.out.println("Ни один обработчик не может обработать запрос: " + request.getContent());
        }
    }

    @Override
    protected boolean canHandle(Request request) {
        return true;
    }
}