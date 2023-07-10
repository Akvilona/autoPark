package ru.autopark.exception;

public class CustomerNotFoundExcepton extends RuntimeException {

    public CustomerNotFoundExcepton() {
        super();
    }

    public CustomerNotFoundExcepton(final String message) {
        super(message);
    }
}
