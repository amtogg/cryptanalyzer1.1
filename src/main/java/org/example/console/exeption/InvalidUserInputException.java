package org.example.console.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor

public class InvalidUserInputException extends RuntimeException {
    String reason;
    public InvalidUserInputException(String reason, Throwable cause) {
        super(reason, cause);
        this.reason = reason;
    }
}

