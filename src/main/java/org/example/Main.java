package org.example;

import org.example.model.BruteForceModel;
import org.example.model.CryptoModel;
import org.example.service.BruteForceService;
import org.example.service.ConsoleService;
import org.example.service.CryptoService;

import java.util.Scanner;

import static org.example.constants.Constants.ENTER_FILENAME_DECRYPTION;
import static org.example.constants.Constants.ENTER_FILE_NAME_ENCRYPTION;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CryptoModel cryptoModel = new CryptoModel();
        BruteForceModel bruteForceModel = new BruteForceModel();
        CryptoService cryptoService = new CryptoService();
        ConsoleService consoleService = new ConsoleService(scanner);
        BruteForceService bruteForceService = new BruteForceService();

        // encrypt
        cryptoService.encrypt(consoleService.createCryptoModel(ENTER_FILE_NAME_ENCRYPTION));
        // decrypt
        cryptoService.deCrypt(consoleService.createCryptoModel(ENTER_FILENAME_DECRYPTION));
        // brute force decrypt
        bruteForceService.bruteForce(consoleService.createBruteForceModel());

    }
}