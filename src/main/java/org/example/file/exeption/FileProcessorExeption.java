package org.example.file.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.security.PublicKey;

@AllArgsConstructor
@Getter
public class FileProcessorExeption extends  RuntimeException{
    String reason;

    public FileProcessorExeption (String reason, Throwable cause){
        super(cause);
        this.reason = reason;
        // почему нельзя их местами поменять и выдает ошибку?

    }

}
