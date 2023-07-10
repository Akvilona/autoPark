/**
 * Создал Андрей Антонов 29.06.2023 19:17
 **/
package ru.autopark.service;

import ru.autopark.model.Vehicle;
import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;

import java.time.LocalDate;

public interface VehicleService {
    Vehicle save(Vehicle vehicle);

    Vehicle findById(long vehicleId);

    Vehicle[] findAll();

    Vehicle[] findAll(Long id, Brand brand, Model model, LocalDate releaseDate, Integer mileage);

    boolean deleteById(long vehicleId);

    Vehicle update(Vehicle vehicle);
}
