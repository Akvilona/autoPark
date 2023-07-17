/**
 * Создал Андрей Антонов 02.07.2023 19:33
 **/
package ru.autopark.repository;

import ru.autopark.model.Rent;

import java.util.Optional;

//TODO: extends CrudRepository
public interface RentRepository {
    Optional<Rent> findByCustomerId(long customerId);

    //TODO: remove
    Optional<Rent> save(Rent rent);

    Optional<Rent> findById(long rentId);

    Rent[] findAll();

    boolean deleteById(long rentId);

    Optional<Rent> update(Rent rent);

}
