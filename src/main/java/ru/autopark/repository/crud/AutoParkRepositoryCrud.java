/**
 * Создал Андрей Антонов 17.07.2023 18:20
 **/
package ru.autopark.repository.crud;

import ru.autopark.model.AutoPark;
import ru.autopark.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutoParkRepositoryCrud implements CrudRepository<AutoPark> {
    private final List<AutoPark> autoParks = new ArrayList<>();

    @Override
    public Optional<AutoPark> save(final AutoPark autoPark) {
        autoParks.add(autoPark);
        return Optional.of(autoPark);
    }

    @Override
    public Optional<AutoPark> findById(final Long tId) {
        for (AutoPark autoPark : autoParks) {
            if (autoPark.getId().equals(tId)) {
                return Optional.of(autoPark);
            }
        }
        return Optional.empty();
    }

    @Override
    public AutoPark[] findAll() {
        AutoPark[] autoParks1 = new AutoPark[autoParks.size()];
        int i = 0;
        for (AutoPark autoPark : autoParks) {
            autoParks1[i].setId(autoPark.getId());
            autoParks1[i].setName(autoPark.getName());
            i++;
        }
        return autoParks1;
    }

    @Override
    public boolean deleteById(final Long tId) {
        return autoParks.remove(tId);
    }

    @Override
    public AutoPark update(final AutoPark autoPark) {
        for (AutoPark autoPark1 : autoParks) {
            if (autoPark1.getId().equals(autoPark.getId())) {
                autoPark1.setName(autoPark.getName());
                return autoPark1;
            }
        }
        return new AutoPark();
    }
}
