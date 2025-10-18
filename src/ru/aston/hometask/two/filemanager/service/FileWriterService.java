package ru.aston.hometask.two.filemanager.service;

import ru.aston.hometask.two.filemanager.exception.FileOperationException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWriterService implements FileService {
    private final Scanner scanner;

    public FileWriterService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(String filePath) throws FileOperationException {
        try {
            Path path = Paths.get(filePath);

            Path parentDir = path.getParent();
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }

            System.out.println("\n=== РЕЖИМ ЗАПИСИ ===");
            System.out.println("Введите текст для записи в файл.");
            System.out.println("Для завершения ввода введите пустую строку.");

            List<String> lines = new ArrayList<>();
            int lineNumber = 1;

            while (true) {
                System.out.printf("Строка %d: ", lineNumber);
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    break;
                }

                lines.add(line);
                lineNumber++;
            }

            if (lines.isEmpty()) {
                System.out.println("Не введено ни одной строки. Запись отменена.");
                return;
            }

            Files.write(path, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.printf("Успешно записано %d строк в файл: %s%n%n", lines.size(), filePath);

        } catch (FileOperationException e) {
            throw e;
        } catch (Exception e) {
            throw new FileOperationException("Ошибка при записи в файл: " + filePath, e);
        }
    }
}
