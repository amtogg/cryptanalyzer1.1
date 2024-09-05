package org.example.console;

import lombok.Getter;


import lombok.AllArgsConstructor;
@Getter
@AllArgsConstructor
public enum Operation {
    EXIT(0, "выход", () -> System.out.println("Операция 0")),
    ENCRYPTION(1, "шифрование", () -> System.out.println("Операция 1")),
    DECRYPTION(2, "расшифрование", () -> System.out.println("Операция 2")),
    BRUTE_FORCE(3, "брутфорс", () -> System.out.println("Операция 3"));


    private final Integer number;
    private final String description;
    private final Runnable runnable;


    public static Operation getByNumber(Integer number) {
        for (Operation operation : values()) {
            if (operation.getNumber().equals(number)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Неизвестное число операции: " + number);
    }

}
