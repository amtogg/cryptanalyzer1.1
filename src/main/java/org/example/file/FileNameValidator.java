package org.example.file;

import org.example.file.exeption.FileProcessorExeption;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;

import static org.example.constants.Constants.SYSTEM_FILES;

public class FileNameValidator {

    //проверяет не содержит ли путь системные папки
    private static final List<String> FORBIDEN_SYSTEM_FILES = List.of(SYSTEM_FILES);
    public void validateForWriting (String fileName){
        Path path = validatePath(fileName);
        if (Files.exists(path)) {
            if (Files.isDirectory(path)){
                throw new FileProcessorExeption("Файл " + path + " является директорией");
            }
            if (!Files.isDirectory(path)){
                throw new FileProcessorExeption("Файл " + path + " недоступен для запси");
            }
        }
    }

    public void validateForReading (String fileName){
        Path path = validatePath(fileName);

        if (Files.notExists(path)){
            throw new FileProcessorExeption("Файл" + path + " не найден");
        }
        if (Files.isDirectory(path)){
            throw new FileProcessorExeption("Файл " + path + " является директорией");
        }
        if (!Files.isReadable(path)){
            throw new FileProcessorExeption("Файл " + path + " недоступен для чтения");
        }
    }

    private Path validatePath(String fileName){
        for (String path : fileName.split(System.getProperty("file.separator"))){
            if (FORBIDEN_SYSTEM_FILES.contains(path)){
                throw new FileProcessorExeption("Недопустимый путь к системной папке " + path);
            }
        }
        try {
            Path path = Path.of(fileName);
            return path;
        } catch (InvalidPathException e) {
            throw new FileProcessorExeption("Неверный путь к файлу" + e.getMessage(), e);
        }
    }
}
