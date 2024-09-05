package org.example.ceasar.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CaesarCodingException extends RuntimeException {
    public CaesarCodingException(String reason) {
        super(reason);
    }
}
