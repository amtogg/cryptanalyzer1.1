package org.example.service;

import org.example.model.BruteForceModel;

public class BruteForceService {
    public String bruteForce (BruteForceModel bruteForceModel){
        checkNullParamOnDeCrypt(bruteForceModel);
        return "файл успешно расшифрован с помощью взлома через брутфорс";
    }


    private String checkNullParamOnDeCrypt(BruteForceModel bruteForceModel) {
        if (bruteForceModel.getPathFrom() == null){
            return "Невозможно найти файл для расшифровки";
        }
        if (bruteForceModel.getPathExample() == null){
            return "Невозможно найти файл с примером";
        }
        if (bruteForceModel.getPathResult() == null){
            return "Невозможно найти файл с результатом взлома";
            //TODO create
        }
        return "";
    }
}
