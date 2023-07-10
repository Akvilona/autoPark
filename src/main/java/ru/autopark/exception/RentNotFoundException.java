/**
 * Создал Андрей Антонов 10.07.2023 16:13
 **/
package ru.autopark.exception;

public class RentNotFoundException extends RuntimeException {
    public RentNotFoundException() {
        super();
    }

    public RentNotFoundException(final String message) {
        super(message);
    }
}
