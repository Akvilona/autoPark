/**
 * Создал Андрей Антонов 02.07.2023 19:41
 **/
package ru.autopark.repository;

import ru.autopark.model.AutoPark;
import ru.autopark.model.Customer;

public interface AutoParkRepository {

    AutoPark save(AutoPark autoPark);

    //Опционально
    AutoPark findByName(String name);

    AutoPark findById(long AutoParkId);

    AutoPark[] findAll();

    boolean deleteById(long customerId);

    AutoPark update(AutoPark autoPark);

}
