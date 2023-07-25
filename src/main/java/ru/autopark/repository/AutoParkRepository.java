/**
 * Создал Андрей Антонов 02.07.2023 19:41
 **/
package ru.autopark.repository;

import ru.autopark.model.AutoPark;

import java.util.List;
import java.util.Optional;

public interface AutoParkRepository {

    //Опционально
    Optional<AutoPark> findByName(String name);


    Optional<AutoPark> save(AutoPark autoPark);

    Optional<AutoPark> findById(long autoParkId);

    List<AutoPark> findAll();

    boolean deleteById(long customerId);

    Optional<AutoPark> update(AutoPark autoPark);

}
