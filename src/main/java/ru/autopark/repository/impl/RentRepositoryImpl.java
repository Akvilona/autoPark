/**
 * Создал Андрей Антонов 02.07.2023 20:27
 **/
package ru.autopark.repository.impl;

import ru.autopark.exception.RentNotFoundException;
import ru.autopark.model.Rent;
import ru.autopark.repository.RentRepository;
import ru.autopark.util.Util;

import java.util.Optional;

public class RentRepositoryImpl implements RentRepository {
    //TODO: refactor with ArrayList
    private static final int RENT_COUNT = 50;
    private final Rent[] rents = new Rent[RENT_COUNT];

    @Override
    public Optional<Rent> save(final Rent rent) {
        int index = Util.findEmptyIndex(rents);
        if (index == -1) {
            return Optional.empty();
        }
        rents[index] = rent;
        return Optional.of(rent);
    }

    @Override
    public Optional<Rent> findById(final long rentId) {
        for (Rent rent : rents) {
            if (rent.getId() == rentId) {
                return Optional.of(rent);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(final long rentId) {
        for (int i = 0; i < rents.length; i++) {
            if (rents[i].getId() == rentId) {
                rents[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Rent> update(final Rent rent) {
        Optional<Rent> rentForUpdate = findById(rent.getId());
        if (rentForUpdate.isPresent()) {
            Rent rentGet = rentForUpdate.get();
            rentGet.setAutoParkId(rent.getAutoParkId());
            rentGet.setVehicleId(rent.getVehicleId());
            rentGet.setCustomerId(rent.getCustomerId());
            rentGet.setCreateDateTime(rent.getCreateDateTime());
            rentGet.setId(rent.getId());
            return Optional.of(rentGet);
        }

        throw new RentNotFoundException("Cant find rent with id: " + rent.getId());
    }

    @Override
    public Rent[] findAll() {
        return this.rents;
    }

    @Override
    public Optional<Rent> findByCustomerId(final long customerId) {
        for (int i = 0; i < rents.length; i++) {
            if (rents[i] != null && rents[i].getCustomerId() == customerId) {
                return Optional.of(rents[i]);
            }
        }
        return Optional.empty();
    }
}
