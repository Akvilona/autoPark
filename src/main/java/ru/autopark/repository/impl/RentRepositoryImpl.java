/**
 * Создал Андрей Антонов 02.07.2023 20:27
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.Rent;
import ru.autopark.repository.CustomerRepository;
import ru.autopark.repository.RentRepository;
import ru.autopark.util.Util;

public class RentRepositoryImpl implements RentRepository {

    private final Rent[] rents = new Rent[50];

    @Override
    public Rent save(Rent rent) {
        int index = Util.findEmptyIndex(rents);
        if (index == -1) {
            return null;
        }
        rents[index] = rent;
        return rent;
    }

    @Override
    public Rent findByRentName(String CustomerName) {

        /** получаем идентификатор записи по имени клиента */
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        long customerId = customerRepository.findByNameAndPhone(CustomerName, null).getId();

        for (Rent rent : rents) {
            if (rent.getCustomerId().equals(customerId)) {
                return rent;
            }
        }
        return null;
    }

    @Override
    public Rent findById(long rentId) {
        for (Rent rent: rents) {
            if (rent.getId() == rentId) {
                return rent;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(long customerId) {
        for (int i = 0; i < rents.length; i++) {
            if (rents[i].getId() == customerId) {
                rents[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Rent update(Rent rent) {
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
}
