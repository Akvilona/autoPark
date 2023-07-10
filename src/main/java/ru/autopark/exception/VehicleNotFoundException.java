/**
 * Создал Андрей Антонов 10.07.2023 16:16
 **/
package ru.autopark.exception;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException() {
        super();
    }

    public VehicleNotFoundException(final String message) {
        super(message);
    }
}
