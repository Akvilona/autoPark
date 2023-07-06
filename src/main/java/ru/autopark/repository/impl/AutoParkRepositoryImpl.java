/**
 * Создал Андрей Антонов 02.07.2023 20:03
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.AutoPark;
import ru.autopark.model.Customer;
import ru.autopark.repository.AutoParkRepository;
import ru.autopark.util.Util;

import javax.lang.model.type.NullType;

public class AutoParkRepositoryImpl implements AutoParkRepository {
    private static final int AUTO_PARK_COUNT = 60;
    private final AutoPark[] autoParks = new AutoPark[AUTO_PARK_COUNT];

    @Override
    public AutoPark save(AutoPark autoPark) {
        int index = Util.findEmptyIndex(autoParks);
        if (index == -1) {
            return null;
        }
        autoParks[index] = autoPark;
        return autoPark;
    }

    @Override
    public AutoPark findByName(String name) {
        for (AutoPark autoPark : autoParks) {
            // не понимаю, почему если я передаю несуществующее имя в поле name, то autoPark = null
            if (autoPark != null){
                if (autoPark.getName().equals(name)) {
                    return autoPark;
                }
            }
        }
        return null;
    }

    @Override
    public AutoPark findById(long autoParkId) {
        for (AutoPark autoPark: autoParks) {
            if (autoPark != null) {
                if (autoPark.getId() == autoParkId) {
                    return autoPark;
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(long autoParkId) {
        for (int i = 0; i < autoParks.length; i++) {
            // такая же непонятная ситуация, если я предаю несуществующий идентификатор, то объект не существует
            if (autoParks[i] != null) {
                if (autoParks[i].getId() == autoParkId) {
                    autoParks[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public AutoPark update(AutoPark autoPark) {
        AutoPark autoPark1 = findById(autoPark.getId());
        autoPark1.setName(autoPark.getName());
        return autoPark1;
    }

    @Override
    public AutoPark[] findAll() {
        return this.autoParks;
    }
}
