/**
 * Создал Андрей Антонов 02.07.2023 20:03
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.AutoPark;
import ru.autopark.repository.AutoParkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutoParkRepositoryImpl implements AutoParkRepository {
    private static final int AUTO_PARK_COUNT = 60;
    private final List<AutoPark> autoParks = new ArrayList<>();

    @Override
    public Optional<AutoPark> save(final AutoPark autoPark) {
        autoParks.add(autoPark);
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
    public List<AutoPark> findAll() {
        return this.autoParks;
    }
}
