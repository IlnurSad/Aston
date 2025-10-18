package ru.aston.hometask.two.filemanager.enums;

import java.util.Objects;

public enum StrategyType {

    READ_TYPE("1"),
    WRITE_TYPE("2");

    private final String command;

    StrategyType(String command) {
        this.command = command;
    }

    public static StrategyType fromString(String command) {
        for (StrategyType type : StrategyType.values()) {
            if (Objects.equals(command, type.command)) {
                return type;
            }
        }
        return null;
    }
}
