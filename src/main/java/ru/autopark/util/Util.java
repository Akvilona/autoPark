package ru.autopark.util;

public final class Util {

    private Util() {
    }

    public static <T> int findEmptyIndex(final T[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;
    }

}
