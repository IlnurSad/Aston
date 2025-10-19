package ru.aston.hometask.three.chain_of_responsibility;

public class TechnicalSupportHandler extends AbstractHandler {
    private static final String REQUEST_TYPE_TECHNICAL = "technical";

    @Override
    public void handle(Request request) {
        if (canHandle(request)) {
            System.out.println("Техническая поддержка обрабатывает запрос: " + request.getContent());
        } else {
            super.handle(request);
        }
    }

    @Override
    protected boolean canHandle(Request request) {
        return REQUEST_TYPE_TECHNICAL.equals(request.getType()) && request.getPriority() <= 2;
    }
}