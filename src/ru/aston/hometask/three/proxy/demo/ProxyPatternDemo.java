package ru.aston.hometask.three.proxy.demo;

import ru.aston.hometask.three.proxy.Image;
import ru.aston.hometask.three.proxy.ImageProxy;
import ru.aston.hometask.three.proxy.LoggingImageProxy;
import ru.aston.hometask.three.proxy.ProtectedImageProxy;
import ru.aston.hometask.three.proxy.User;

import java.util.List;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Virtual Proxy ===");
        final Image image1 = new ImageProxy("photo1.jpg");
        System.out.println("Файл: " + image1.getFileName());
        image1.display();

        System.out.println("\n=== Protection Proxy ===");
        final User admin = new User("Админ", List.of("IMAGE_VIEW", "IMAGE_EDIT"));
        final User guest = new User("Гость", List.of());

        final Image protectedImage1 = new ProtectedImageProxy("secret.jpg", admin);
        final Image protectedImage2 = new ProtectedImageProxy("secret.jpg", guest);

        protectedImage1.display();
        protectedImage2.display();

        System.out.println("\n=== Logging Proxy ===");
        final Image loggedImage = new LoggingImageProxy("landscape.jpg");
        loggedImage.display();
    }
}