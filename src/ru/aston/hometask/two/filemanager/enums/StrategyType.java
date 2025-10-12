package ru.aston.hometask.two.filemanager.enums;

public enum StrategyType {

    READ_TYPE("1"),
    WRITE_TYPE("2");
    private final String command;

    StrategyType(String command) {
        this.command = command;
    }

    public static StrategyType fromString(String command) {
        for (StrategyType type : StrategyType.values()) {
            if (type.command.equals(command)) {
                return type;
            }
        }
        return null;
    }
}
