package org.example.ceasar.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CaesarAlphabetException extends Throwable {
    String reason;

    public CaesarAlphabetException(String reason, Throwable cause){
        super(cause);
        this.reason = reason;
        // почему нельзя их местами поменять и выдает ошибку?

    }
}
