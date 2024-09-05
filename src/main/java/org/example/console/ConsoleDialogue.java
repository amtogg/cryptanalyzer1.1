package org.example.console;

import org.example.ceasar.CaesarCoder;
import org.example.ceasar.exeption.*;
import org.example.file.exeption.FileProcessorExeption;
import org.example.console.exeption.InvalidUserInputException;
import java.util.Scanner;

import static java.nio.file.Files.readString;

public class ConsoleDialogue implements Dialogue{
    private static final String WELCOME_MESSAGE = """
            
            Welcome !!!
            
            """;
    private static final String OPERATION_PATTERN = "%d - %s";
    public static final String TRY_AGAIN_COMMAND = "повторите команду";
    private final Scanner in;
    private static CaesarCoder caesarCoder;
    public ConsoleDialogue() {
        in = new Scanner(System.in);
        caesarCoder = new CaesarCoder();
    }
    @Override
    public void start() {
        showMenu();
        Operation operation = readOperation();
        processOperation(operation);

    }
    private void showMenu() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("Попробуйте другие опции для продолжения: ");
        for (Operation operation : Operation.values()) {
            String message = String.format(OPERATION_PATTERN, operation.getNumber(), operation.getDescription());
            System.out.println(message);
        }
    }

    private Operation readOperation() {
        boolean shouldTryAgain = false;
        do {
            try {
                Integer option = readInteger();
                return Operation.getByNumber(option);
            } catch (IllegalArgumentException | InvalidUserInputException e) {
                System.out.println("Номер операции неверный");
                System.out.println("причина: " + e.getMessage());
                System.out.println("Нажмите 'again' для повторной попытки ввода или что-нибудь для выхода. ");
                String input = readString();
                if (TRY_AGAIN_COMMAND.equals(input)) {
                    shouldTryAgain = true;
                }
            }
        } while (shouldTryAgain);
        return Operation.EXIT;
    }
    private void  processOperation(Operation operation) {
        switch (operation){
            case EXIT -> processExit();
            case ENCRYPTION -> processEncryptionOperation();
            case DECRYPTION -> processDecryptionOperation();
        }
    }
    private void processEncryptionOperation(){
        System.out.println("Введите имя файла, который содержит исходный текст: ");
        String inputFileName = readString();
        System.out.println("Введите имя файла, куда нужно сохрать результат: ");
        String outputFilename = readString();
        System.out.println("Введите ключ: ");
        Integer key = readInteger();

        try {
            caesarCoder.encrypt(inputFileName, outputFilename, key);
            System.out.println("Файл успешно зашифрован");
        } catch (FileProcessorExeption | CaesarCodingException e) {
            System.err.println("Ошибка при шифровании файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private void processDecryptionOperation(){
        System.out.println("Введите имя файла, который содержит зашифрованный текст: ");
        String inputFileName = readString();

        System.out.println("Введите имя файла, куда нужно сохранить результат: ");
        String outputFilename = readString();

        System.out.println("Введите ключ: ");
        Integer key = readInteger();
        try {
            caesarCoder.decrypt(inputFileName, outputFilename, key);
            System.out.println("Файл успешно расшифрован");
        } catch (FileProcessorExeption | CaesarCodingException e) {
            System.err.println("Ошибка при шифровании файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private void processExit(){
        System.out.println("Пока!");
    }
    private Integer readInteger(){
        String inputFileName =in.nextLine();
        try {
            return Integer.parseInt(inputFileName);
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException ("Не удалось преобразовать введенное значение в число", e);
        }
    }

    private String readString(){
        String inputFileName =in.nextLine();
        try {
            return inputFileName;
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException ("Не удалось преобразовать введенное значение в текст", e);
        }
    }
}
