/**
 * Создал Андрей Антонов 23.07.2023 14:36
 **/
package ru.autopark.repository.crud;

import ru.autopark.model.Rent;
import ru.autopark.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentRepositoryCrud implements CrudRepository<Rent> {
    private final List<Rent> rentList = new ArrayList<>();

    @Override
    public Optional<Rent> save(final Rent rent) {
        rentList.add(rent);
        return Optional.of(rent);
    }

    @Override
    public Optional<Rent> findById(final Long tId) {
        for (Rent rent : rentList) {
            if (rent.getId().equals(tId)) {
                return Optional.of(rent);
            }
        }
        return Optional.empty();
    }

    @Override
    public Rent[] findAll() {
        Rent[] rents = new Rent[rentList.size()];
        int i = 0;
        for (Rent rent : rentList) {
            rents[i].setId(rent.getId());
            rents[i].setCustomerId(rent.getCustomerId());
            rents[i].setVehicleId(rent.getVehicleId());
            rents[i].setAutoParkId(rent.getAutoParkId());
            rents[i].setCreateDateTime(rent.getCreateDateTime());
            rents[i].setDuration(rent.getDuration());
        }
        return rents;
    }

    @Override
    public boolean deleteById(final Long tId) {
        return rentList.remove(tId);
    }

    @Override
    public Rent update(final Rent rent) {
        for (Rent rent1: rentList) {
            if (rent1.getId().equals(rent.getId())) {
                rent1.setDuration(rent.getDuration());
                rent1.setCreateDateTime(rent.getCreateDateTime());
                rent1.setVehicleId(rent.getVehicleId());
                rent1.setAutoParkId(rent.getAutoParkId());
                rent1.setCustomerId(rent.getCustomerId());
                return rent1;
            }
        }
        return new Rent();
    }
}
