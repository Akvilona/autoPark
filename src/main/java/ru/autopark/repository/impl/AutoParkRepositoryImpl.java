/**
 * Создал Андрей Антонов 02.07.2023 20:03
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.AutoPark;
import ru.autopark.repository.AutoParkRepository;
import ru.autopark.util.Util;

import java.util.Optional;

public class AutoParkRepositoryImpl implements AutoParkRepository {
    private static final int AUTO_PARK_COUNT = 60;
    private final AutoPark[] autoParks = new AutoPark[AUTO_PARK_COUNT];

    @Override
    public Optional<AutoPark> save(final AutoPark autoPark) {
        int index = Util.findEmptyIndex(autoParks);
        if (index == -1) {
            return Optional.empty();
        }
        autoParks[index] = autoPark;
        return Optional.of(autoPark);
    }

    @Override
    public Optional<AutoPark> findByName(final String name) {
        for (AutoPark autoPark : autoParks) {
            if (autoPark != null && autoPark.getName().equals(name)) {
                return Optional.of(autoPark);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<AutoPark> findById(final long autoParkId) {
        for (AutoPark autoPark : autoParks) {
            if (autoPark != null && autoPark.getId() == autoParkId) {
                return Optional.of(autoPark);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(final long autoParkId) {
        for (int i = 0; i < autoParks.length; i++) {
            if (autoParks[i] != null && autoParks[i].getId() == autoParkId) {
                autoParks[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<AutoPark> update(final AutoPark autoPark) {
        Optional<AutoPark> autoPark1 = findById(autoPark.getId());
        AutoPark autoPark2 = autoPark1.get();
        autoPark2.setName(autoPark.getName());
        return Optional.of(autoPark2);
    }

    @Override
    public AutoPark[] findAll() {
        return this.autoParks;
    }
}
