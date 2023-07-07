/**
 * Создал Андрей Антонов 02.07.2023 20:27
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.Rent;
import ru.autopark.repository.CustomerRepository;
import ru.autopark.repository.RentRepository;
import ru.autopark.util.Util;

public class RentRepositoryImpl implements RentRepository {
    private static final int RENT_COUNT = 50;
    private final Rent[] rents = new Rent[RENT_COUNT];

    @Override
    public Rent save(final Rent rent) {
        int index = Util.findEmptyIndex(rents);
        if (index == -1) {
            return null;
        }
        rents[index] = rent;
        return rent;
    }

    @Override
    public Rent findById(final long rentId) {
        for (Rent rent : rents) {
            if (rent.getId() == rentId) {
                return rent;
            }
        }
        return null;
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
    public Rent update(final Rent rent) {
        Rent rentForUpdate = findById(rent.getId());
        rentForUpdate.setAutoParkId(rent.getAutoParkId());
        rentForUpdate.setVehicleId(rent.getVehicleId());
        rentForUpdate.setCustomerId(rent.getCustomerId());
        rentForUpdate.setCreateDateTime(rent.getCreateDateTime());
        rentForUpdate.setId(rent.getId());
        return rentForUpdate;
    }

    @Override
    public Rent[] findAll() {
        return this.rents;
    }

    @Override
    public Rent findByCustomerId(long customerId) {
        for (int i = 0; i < rents.length; i++) {
            if (rents[i] != null && rents[i].getCustomerId() == customerId) {
                return rents[i];
            }
        }
        return null;
    }
}
