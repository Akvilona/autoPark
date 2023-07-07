/**
 * Создал Андрей Антонов 02.07.2023 19:33
 **/
package ru.autopark.repository;

import ru.autopark.model.Rent;

public interface RentRepository {

    Rent save(Rent rent);

    Rent findById(long rentId);

    Rent findByCustomerId(long customerId);

    Rent[] findAll();

    boolean deleteById(long rentId);

    Rent update(Rent rent);

}
