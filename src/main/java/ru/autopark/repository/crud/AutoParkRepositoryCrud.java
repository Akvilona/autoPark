/**
 * Создал Андрей Антонов 17.07.2023 18:20
 **/
package ru.autopark.repository.crud;

import ru.autopark.model.AutoPark;
import ru.autopark.repository.CrudRepository;
import ru.autopark.util.Util;

import java.util.ArrayList;
import java.util.Optional;

public class AutoParkRepositoryCrud<AutoPark> implements CrudRepository<AutoPark> {

//    private static final int AUTO_PARK_COUNT = 60;
//    private final AutoPark[] autoParks = new AutoPark[AUTO_PARK_COUNT];
    private final ArrayList<AutoPark> autoParks =  new ArrayList<>();

    @Override
    public Optional<AutoPark> save(AutoPark autoPark) {
        int index = Util.findEmptyIndex(autoParks);
        if (index == -1) {
            return Optional.empty();
        }
        autoParks.set(index, autoPark);
        return Optional.of(autoPark);    }

    @Override
    public Optional<AutoPark> findById(Long tId) {
        for (AutoPark autoPark : autoParks) {
//            if (autoPark != null && autoPark.getName().equals(name)) {
                return Optional.of(autoPark);
//            }
        }
        return Optional.empty();
    }

    @Override
    public AutoPark[] findAll() {
        return null;
    }

    @Override
    public boolean deleteById(Long tId) {
        return false;
    }

    @Override
    public AutoPark update(AutoPark autoPark) {
        return null;
    }
}
