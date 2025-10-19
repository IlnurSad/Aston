package ru.aston.hometask.three.chain_of_responsibility;

public class Request {
    private final String type;
    private final String content;
    private final int priority;

    public Request(String type, String content, int priority) {
        this.type = type;
        this.content = content;
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public int getPriority() {
        return priority;
    }
}