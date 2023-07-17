/**
 * Создал Андрей Антонов 10.07.2023 19:31
 **/
package ru.autopark.service;

import ru.autopark.model.AutoPark;

import java.util.Optional;

public interface AutoParkService {

    Optional<AutoPark> save(AutoPark autoPark);

    //Опционально
    Optional<AutoPark> findByName(String name);

    Optional<AutoPark> findById(long autoParkId);

    AutoPark[] findAll();

    Optional<Boolean> deleteById(long customerId);

    Optional<AutoPark> update(AutoPark autoPark);
}
