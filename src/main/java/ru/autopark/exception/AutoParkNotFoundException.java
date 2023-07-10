/**
 * Создал Андрей Антонов 10.07.2023 16:16
 **/
package ru.autopark.exception;

public class AutoParkNotFoundException extends RuntimeException {
    public AutoParkNotFoundException() {
        super();
    }

    public AutoParkNotFoundException(final String message) {
        super(message);
    }
}
