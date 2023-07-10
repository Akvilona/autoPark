/**
 * Создал Андрей Антонов 30.06.2023 10:47
 **/
package ru.autopark.repository;

import ru.autopark.model.Vehicle;

public interface VehicleRepository {

    Vehicle save(Vehicle vehicle);

    Vehicle findById(long vehicleId);

    Vehicle[] findAll();

    boolean deleteById(long vehicleId);

    Vehicle update(Vehicle vehicle);

}
