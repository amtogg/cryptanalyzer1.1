package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.BruteForceModel;
import org.example.model.CryptoModel;

import java.util.Scanner;

import static org.example.constants.Constants.*;
@AllArgsConstructor
public class ConsoleService {
    CryptoModel cryptoModel = new CryptoModel();


    private final Scanner scanner;
    public ConsoleService(Scanner scanner) {
        this.scanner = scanner;
    }
    BruteForceModel bruteForceModel = new BruteForceModel();

    public BruteForceModel createBruteForceModel (){
        System.out.println(ENTER_FILE_NAME_ENCRYPTED);
        bruteForceModel.setPathFrom(scanner.nextLine());
        System.out.println(ENTER_FILE_NAME_EXAMPLE);
        bruteForceModel.setPathExample(scanner.nextLine());
        System.out.println(ENTER_FILE_NAME_HACK_RESULT);
        bruteForceModel.setPathResult(scanner.nextLine());
        return bruteForceModel;
    }
    public CryptoModel createCryptoModel(String enterFileNameEncryptionOrDecryption) {
        System.out.println(enterFileNameEncryptionOrDecryption);
        cryptoModel.setFileSourcePath(scanner.nextLine());
        System.out.println(ENTER_FILE_NAME_SAVE);
        cryptoModel.setFileSavePath(scanner.nextLine());
        System.out.println(ENTER_KEY);
        cryptoModel.setKey(scanner.nextInt());
        return cryptoModel;
    }
}

