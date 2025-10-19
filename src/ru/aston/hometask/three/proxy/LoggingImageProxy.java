package ru.aston.hometask.three.proxy;

import java.util.Date;

public class LoggingImageProxy implements Image {
    private RealImage realImage;
    private final String fileName;

    public LoggingImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        log("Попытка отображения изображения: " + fileName);
        long startTime = System.currentTimeMillis();

        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();

        long endTime = System.currentTimeMillis();
        log("Изображение отображено за " + (endTime - startTime) + "мс");
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    private void log(String message) {
        System.out.println("[LOG] " + new Date() + " - " + message);
    }
}