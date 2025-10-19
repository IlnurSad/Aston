package ru.aston.hometask.three.proxy;

public class ProtectedImageProxy implements Image {
    private RealImage realImage;
    private final String fileName;
    private final User user;
    private static final String PERMISSION_IMAGE_VIEW = "IMAGE_VIEW";

    public ProtectedImageProxy(String fileName, User user) {
        this.fileName = fileName;
        this.user = user;
    }

    @Override
    public void display() {
        if (hasAccess()) {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        } else {
            System.out.println("Ошибка: У пользователя " + user.getName() +
                    " нет доступа к изображению " + fileName);
        }
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    private boolean hasAccess() {
        return user != null && user.hasPermission(PERMISSION_IMAGE_VIEW);
    }
}