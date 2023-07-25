/**
 * Создал Андрей Антонов 24.07.2023 13:41
 **/
package generic;

import ru.autopark.util.Util;

import java.util.Arrays;

public class ArrayChange {
    private static final int ARRAY_COUNT = 200;
    private final Integer[] arrays = new Integer[ARRAY_COUNT];

    @Override
    public String toString() {
        return "ArrayChange{"
                + "arrays=" + Arrays.toString(arrays)
                + '}';
    }

    public ArrayChange() {
    }

    public void addElementArray(final int a) {
        int empty = Util.findEmptyIndex(arrays);

        if (empty >= 0) {
            for (int i = empty; i < a + empty; i++) {
                arrays[i] = i;
            }
        }
    }

    public int swapPlaces(final int a, final int b) {
        int empty = Util.findEmptyIndex(arrays);
        if (empty > a && empty > b) {
            int c = arrays[a];
            arrays[a] = arrays[b];
            arrays[b] = c;
            System.out.println(Arrays.toString(arrays));
            return 1;

        }
        return -1;
    }
}

