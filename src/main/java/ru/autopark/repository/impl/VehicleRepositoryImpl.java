/**
 * Создал Андрей Антонов 02.07.2023 13:04
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.Customer;
import ru.autopark.model.Vehicle;
import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;
import ru.autopark.repository.VehicleRepository;
import ru.autopark.util.Util;

import java.time.LocalDate;

public class VehicleRepositoryImpl implements VehicleRepository {

    private static Vehicle[] vehicles = new Vehicle[100]; // массив вместо таблицы базы данных

    @Override
    public Vehicle save(Vehicle vehicle) {
        int index = Util.findEmptyIndex(vehicles);
        if (index == -1) {
            return null;
        }
        vehicles[index] = vehicle;
        return vehicle;
    }

    @Override
    public Vehicle findByAll(Long id, Brand brand, Model model, LocalDate releaseDate, Integer mileage) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                if (vehicle.getBrand().equals(brand) &&
                        vehicle.getModel().equals(model) &&
                        vehicle.getReleaseDate().equals(releaseDate) &&
                        vehicle.getMileage().equals(mileage)) {
                    return vehicle;
                }
            }
        }
        return null;
    }

    @Override
    public Vehicle findById(long vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                if (vehicle.getId() == vehicleId) {
                    return vehicle;
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(long vehicleId) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getId() == vehicleId) {
                vehicles[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        Vehicle vehicleForUpdate = findById(vehicle.getId());
        vehicleForUpdate.setAutoParkId(vehicle.getAutoParkId());
        vehicleForUpdate.setMileage(vehicle.getMileage());
        vehicleForUpdate.setModel(vehicle.getModel());
        vehicleForUpdate.setBrand(vehicle.getBrand());
        vehicleForUpdate.setReleaseDate(vehicle.getReleaseDate());
        return vehicleForUpdate;
    }

    @Override
    public Vehicle[] findAll() {
        return this.vehicles;
    }
}

