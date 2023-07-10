/**
 * Создал Андрей Антонов 10.07.2023 19:31
 **/
package ru.autopark.service;

import ru.autopark.model.AutoPark;

public interface AutoParkService {

    AutoPark save(AutoPark autoPark);

    //Опционально
    AutoPark findByName(String name);

    AutoPark findById(long autoParkId);

    AutoPark[] findAll();

    boolean deleteById(long customerId);

    AutoPark update(AutoPark autoPark);
}
