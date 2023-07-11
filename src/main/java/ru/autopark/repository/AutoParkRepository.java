/**
 * Создал Андрей Антонов 02.07.2023 19:41
 **/
package ru.autopark.repository;

import ru.autopark.model.AutoPark;

import java.util.Optional;

//TODO: extends CrudRepository
public interface AutoParkRepository {

    //Опционально
    AutoPark findByName(String name);


    //TODO: remove
    AutoPark save(AutoPark autoPark);

    Optional<AutoPark> findById(long autoParkId);

    AutoPark[] findAll();

    boolean deleteById(long customerId);

    AutoPark update(AutoPark autoPark);

}
