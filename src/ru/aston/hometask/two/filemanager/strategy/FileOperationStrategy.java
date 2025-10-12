package ru.aston.hometask.two.filemanager.strategy;

import ru.aston.hometask.two.filemanager.enums.StrategyType;
import ru.aston.hometask.two.filemanager.exception.FileOperationException;
import ru.aston.hometask.two.filemanager.service.FileWriterService;
import ru.aston.hometask.two.filemanager.service.FileReaderService;
import ru.aston.hometask.two.filemanager.service.FileService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileOperationStrategy {
    private final Map<StrategyType, FileService> strategies;
    private FileService currentStrategy;

    public FileOperationStrategy(Scanner scanner) {
        this.strategies = new HashMap<>();
        initializeStrategies(scanner);
    }

    private void initializeStrategies(Scanner scanner) {
        strategies.put(StrategyType.READ_TYPE, new FileReaderService());
        strategies.put(StrategyType.WRITE_TYPE, new FileWriterService(scanner));
    }

    public void setStrategy(String strategyKey) {
        FileService strategy = strategies.get(StrategyType.fromString(strategyKey));
        if (strategy != null) {
            this.currentStrategy = strategy;
        } else {
            throw new IllegalArgumentException("Неизвестная стратегия: " + strategyKey);
        }
    }

    public void executeStrategy(String filePath) throws FileOperationException {
        if (currentStrategy == null) {
            throw new IllegalStateException("Стратегия не выбрана!");
        }
        currentStrategy.execute(filePath);
    }

    public Map<String, String> getAvailableStrategies() {
        Map<String, String> available = new HashMap<>();
        available.put("1", "Чтение файла");
        available.put("2", "Запись в файл");
        return available;
    }
}