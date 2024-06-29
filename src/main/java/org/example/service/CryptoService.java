package org.example.service;

import org.example.model.CryptoModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CryptoService {
    // для себя В случае больших файлов метод Files.readAllLines может потреблять много памяти, так как он загружает весь файл в память. В таких случаях лучше использовать BufferedReader.
    public String encrypt (CryptoModel cryptoModel) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cryptoModel.getFileSourcePath()))) {
            String tempLine;
            while ((tempLine = bufferedReader.readLine()) != null) {
                System.out.println(tempLine);
            }
        } catch (IOException e) {
            System.err.println("Не удалось прочитать файл");
        }


        checkNullParamOnCrypt(cryptoModel);
        return "файл успушно зашифрован";
    }
    public String deCrypt (CryptoModel cryptoModel){
        checkNullParamOnCrypt(cryptoModel);
        return "файл успешно расшифрован";
    }


    private static String checkNullParamOnCrypt(CryptoModel cryptoModel) {
        if (cryptoModel.getFileSourcePath() == null) {
            return "Невозможно найти файл для шифрования";
        }
        if (cryptoModel.getFileSavePath() == null){
            // TODO create
        }
        if (cryptoModel.getKey() == null){
            return "Невозможно найти ключ шифрования";
        }
        return null;
    }



}
