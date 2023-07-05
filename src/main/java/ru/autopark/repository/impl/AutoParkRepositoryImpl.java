/**
 * Создал Андрей Антонов 02.07.2023 20:03
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.AutoPark;
import ru.autopark.repository.AutoParkRepository;
import ru.autopark.util.Util;

public class AutoParkRepositoryImpl implements AutoParkRepository {
    private static final int AUTO_PARK_COUNT = 60;
    private final AutoPark[] autoPark = new AutoPark[AUTO_PARK_COUNT];

    @Override
    public long add(final long id, final String name) {
        int index = Util.findEmptyIndex(autoPark);
        AutoPark newAutoPark = new AutoPark(id, name);

        if (index == -1) {
            return index;
        }

        autoPark[index] = newAutoPark;
        return index;
    }

    @Override
    public boolean deleteByName(String name) {
        for (int i = 0; i < autoPark.length; i++) {
            if (autoPark[i].getName().equals(name)) {
                autoPark[i] = null;
                return true;
            }
        }
        return false;
    }
}
