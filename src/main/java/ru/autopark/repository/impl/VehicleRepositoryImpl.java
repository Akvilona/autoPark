/**
 * Создал Андрей Антонов 02.07.2023 13:04
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.Vehicle;
import ru.autopark.repository.VehicleRepository;
import ru.autopark.util.Util;

import java.util.Optional;

public class VehicleRepositoryImpl implements VehicleRepository {

    //TODO: refactor with ArrayList
    private static final int VEHICLECOUNT = 100;
    private static Vehicle[] vehicles = new Vehicle[VEHICLECOUNT]; // массив вместо таблицы базы данных

    @Override
    public Optional<Vehicle> save(final Vehicle vehicle) {
        int index = Util.findEmptyIndex(vehicles);
        if (index == -1) {
            return Optional.empty();
        }
        vehicles[index] = vehicle;
        return Optional.of(vehicle);
    }

    @Override
    public Optional<Vehicle> findById(final long vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getId() == vehicleId) {
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(final long vehicleId) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getId() == vehicleId) {
                vehicles[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Vehicle> update(final Vehicle vehicle) {
        Optional<Vehicle> vehicleOptional = findById(vehicle.getId());
        if (vehicleOptional.isPresent()) {
            Vehicle vehicle1 = vehicleOptional.get();
            vehicle1.setAutoParkId(vehicle.getAutoParkId());
            vehicle1.setMileage(vehicle.getMileage());
            vehicle1.setModel(vehicle.getModel());
            vehicle1.setBrand(vehicle.getBrand());
            vehicle1.setReleaseDate(vehicle.getReleaseDate());
            return Optional.of(vehicle1);
        }
        return Optional.of(vehicle);
    }

    @Override
    public Vehicle[] findAll() {
        return this.vehicles;
    }
}

