/**
 * Создал Андрей Антонов 02.07.2023 20:03
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.AutoPark;
import ru.autopark.repository.AutoParkRepository;

public class AutoParkRepositoryImpl implements AutoParkRepository {
    private final AutoPark[] autoPark = new AutoPark[50]; //  этот массив вместо базы данных

    @Override
    public long add (String name) {
        return find(name);
    }

    @Override
    public long delete (String name) {
        for (int i = 0; i < autoPark.length; i++) {
            if ( autoPark[i].getName() == name) {
                autoPark[i].setName(null);
                autoPark[i].setId(null);
                return i;
            }
        }
        return -1;
    }

    public long find (String name) {
        for (int i = 0; i < autoPark.length; i++) {
            if ( autoPark[i].getName() == null) {
                autoPark[i].setId((long) i);
                autoPark[i].setName(name);
                return i;
            }
        }
        return -1;
    }
}
