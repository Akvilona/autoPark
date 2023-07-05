package ru.autopark.util;

import ru.autopark.model.AutoPark;
import ru.autopark.model.Customer;
import ru.autopark.model.Vehicle;

public final class Util {

    private Util() {
    }

    /**
     * Finds the first empty index in the given array of Customer objects.
     *
     * @param customers an array of Customer objects
     * @return the index of the first empty slot in the array, or -1 if the array is full
     */
    public static int findEmptyIndex(Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static int findEmptyIndex(AutoPark[] autoParks) {
        for (int i = 0; i < autoParks.length; i++) {
            if (autoParks[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static int findEmptyIndex(Vehicle[] vehicles) { /** поиск первого пустого */
        for (int i = 1; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
