package ru.aston.hometask.two.filemanager.service;

import ru.aston.hometask.two.filemanager.exception.FileOperationException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderService implements FileService {

    @Override
    public void execute(String filePath) throws FileOperationException {
        try {
            Path path = Paths.get(filePath);

            if (!Files.exists(path)) {
                throw new FileOperationException("Файл не существует: " + filePath);
            }

            if (!Files.isReadable(path)) {
                throw new FileOperationException("Нет прав на чтение файла: " + filePath);
            }

            List<String> lines = Files.readAllLines(path);

            System.out.println("\n=== СОДЕРЖИМОЕ ФАЙЛА ===");
            if (lines.isEmpty()) {
                System.out.println("Файл пуст");
            } else {
                for (int i = 0; i < lines.size(); i++) {
                    System.out.printf("%3d: %s%n", i + 1, lines.get(i));
                }
            }
            System.out.println("=== КОНЕЦ ФАЙЛА ===\n");

        } catch (FileOperationException e) {
            throw e;
        } catch (Exception e) {
            throw new FileOperationException("Ошибка при чтении файла: " + filePath, e);
        }
    }
}