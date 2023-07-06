/**
 * Создал Андрей Антонов 02.07.2023 19:41
 **/
package ru.autopark.repository;

import ru.autopark.model.AutoPark;

public interface AutoParkRepository {

    AutoPark save(AutoPark autoPark);

    //Опционально
    AutoPark findByName(String name);

    AutoPark findById(long autoParkId);

    AutoPark[] findAll();

    boolean deleteById(long customerId);

    AutoPark update(AutoPark autoPark);

}
