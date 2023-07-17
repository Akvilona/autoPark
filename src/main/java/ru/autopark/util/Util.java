package ru.autopark.util;

import java.util.ArrayList;

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

    public static <T> int findEmptyIndex(ArrayList<T> autoParks) {
        for (int i = 0; i < autoParks.size(); i++) {
            if (autoParks.get(i) == null) {
                return i;
            }
        }
        return -1;
    }
}
