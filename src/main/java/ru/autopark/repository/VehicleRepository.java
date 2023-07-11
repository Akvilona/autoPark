/**
 * Создал Андрей Антонов 30.06.2023 10:47
 **/
package ru.autopark.repository;

import ru.autopark.model.Vehicle;

import java.util.Optional;

//TODO: extends CrudRepository
public interface VehicleRepository {
    //TODO: remove
    Vehicle save(Vehicle vehicle);

    Optional<Vehicle> findById(long vehicleId);

    Vehicle[] findAll();

    boolean deleteById(long vehicleId);

    Vehicle update(Vehicle vehicle);

}
