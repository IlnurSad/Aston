package ru.aston.hometask.two.filemanager.processor;

import ru.aston.hometask.two.filemanager.exception.FileOperationException;
import ru.aston.hometask.two.filemanager.strategy.FileOperationStrategy;

import java.util.Scanner;

public class FileProcessor {
    private final Scanner scanner;
    private final FileOperationStrategy strategy;

    public FileProcessor() {
        this.scanner = new Scanner(System.in);
        this.strategy = new FileOperationStrategy(scanner);
    }

    public void start() {
        System.out.println("=== ФАЙЛОВЫЙ МЕНЕДЖЕР ===");

        while (true) {
            try {
                String filePath = getFilePathFromUser();
                if (filePath == null) continue;

                performFileOperation(filePath);

            } catch (Exception e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private String getFilePathFromUser() {
        System.out.println("\nВведите путь к файлу (или 'exit' для выхода):");
        System.out.print("> ");

        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("exit")) {
            System.exit(0);
        }

        if (input.isEmpty()) {
            System.out.println("Путь не может быть пустым!");
            return null;
        }

        return input;
    }

    private void performFileOperation(String filePath) {
        System.out.println("\nВыберите операцию:");

        var availableStrategies = strategy.getAvailableStrategies();
        availableStrategies.forEach((key, value) ->
                System.out.println(key + " - " + value));
        System.out.println("3 - Выбрать другой файл");
        System.out.print("> ");

        String choice = scanner.nextLine().trim();

        if ("3".equals(choice)) {
            return;
        }

        try {
            strategy.setStrategy(choice);
            strategy.executeStrategy(filePath);

        } catch (IllegalArgumentException e) {
            System.out.println("Неверный выбор! Попробуйте снова.");
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (FileOperationException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}
