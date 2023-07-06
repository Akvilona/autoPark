/**
 * Создал Андрей Антонов 02.07.2023 19:33
 **/
package ru.autopark.repository;

import ru.autopark.model.Customer;
import ru.autopark.model.Rent;

import java.time.Duration;
import java.time.LocalDateTime;

public interface RentRepository {

    Rent save(Rent rent);

    //Опционально
    Rent findByRentName(String name);

    Rent findById(long RentId);

    Rent[] findAll();

    boolean deleteById(long customerId);

    Rent update(Rent rent);

}
