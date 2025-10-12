package ru.aston.hometask.two.filemanager.service;

import ru.aston.hometask.two.filemanager.exception.FileOperationException;

public interface FileService {
    void execute(String filePath) throws FileOperationException;
}
