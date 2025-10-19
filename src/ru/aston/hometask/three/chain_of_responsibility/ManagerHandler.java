package ru.aston.hometask.three.chain_of_responsibility;

public class ManagerHandler extends AbstractHandler {

    @Override
    public void handle(Request request) {
        if (canHandle(request)) {
            System.out.println("Менеджер обрабатывает запрос: " + request.getContent());
        } else {
            super.handle(request);
        }
    }

    @Override
    protected boolean canHandle(Request request) {
        return request.getPriority() == 3;
    }
}