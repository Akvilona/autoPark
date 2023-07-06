/**
 * Создал Андрей Антонов 30.06.2023 10:47
 **/
package ru.autopark.repository;

import ru.autopark.model.Vehicle;
import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;

import java.time.LocalDate;

public interface VehicleRepository {

    Vehicle save(Vehicle vehicle);

    //Опционально
    Vehicle findByAll(Long id, Brand brand, Model model, LocalDate releaseDate, Integer mileage);

    Vehicle findById(long vehicleId);

    Vehicle[] findAll();

    boolean deleteById(long vehicleId);

    Vehicle update(Vehicle vehicle);

}
