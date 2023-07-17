/**
 * Создал Андрей Антонов 29.06.2023 19:17
 **/
package ru.autopark.service;

import ru.autopark.model.Vehicle;
import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;

import java.time.LocalDate;
import java.util.Optional;

public interface VehicleService {
    Optional<Vehicle> save(Vehicle vehicle);

    Optional<Vehicle> findById(long vehicleId);

    Vehicle[] findAll();

    Vehicle[] findAll(Long id, Brand brand, Model model, LocalDate releaseDate, Integer mileage);

    Optional<Boolean> deleteById(long vehicleId);

    Optional<Vehicle> update(Vehicle vehicle);
}
