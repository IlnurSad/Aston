package ru.aston.hometask.two.filemanager.exception;

import java.io.IOException;

public class FileOperationException extends IOException {
    public FileOperationException(String message) {
        super(message);
    }

    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
