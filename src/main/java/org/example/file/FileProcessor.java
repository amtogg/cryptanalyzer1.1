package org.example.file;

import org.example.file.exeption.FileProcessorExeption;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class FileProcessor {
    private static final StandardOpenOption[] FILE_WRITE_OPTIONS = {StandardOpenOption.CREATE, StandardOpenOption.APPEND}; // надо ли оставлять create, если append создает и записывает в файл если такого не существет

    /**
     * @throws IOException добавить (IOException | InvalidPathExeption e) если дальше не будет проверки пути fileName
     */
    public List<String> readFromFile(String fileName) {
    try { Path filePath = Path.of(fileName); // если большой файл, то лучше через бафферед ридер
        return Files.readAllLines(filePath);
    } catch (IOException e)
    {
        throw new FileProcessorExeption(e.getMessage(), e);
        // System.err.println("File not found: " + fileName);
        // return Collections.emptyList();
        // ТАК НЕЛЬЗЯ ДЕЛАТЬ! тогда программа будет рабоать с пустым списком
    }    }

    public void writeToFile(String fileName, String content) {
        try {
            Path filePath = Path.of(fileName);
            Files.writeString(filePath, content, FILE_WRITE_OPTIONS);
        } catch (IOException e) {
            throw new FileProcessorExeption(e.getMessage(), e);
        }
    }
}
