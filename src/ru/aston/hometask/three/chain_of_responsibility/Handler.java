package ru.aston.hometask.three.chain_of_responsibility;

public interface Handler {
    void setNext(Handler handler);
    void handle(Request request);
}