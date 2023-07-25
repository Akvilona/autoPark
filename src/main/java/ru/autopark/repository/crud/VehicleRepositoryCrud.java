/**
 * Создал Андрей Антонов 23.07.2023 14:57
 **/
package ru.autopark.repository.crud;

import ru.autopark.model.Vehicle;
import ru.autopark.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleRepositoryCrud implements CrudRepository<Vehicle> {
    private final List<Vehicle> vehicleList = new ArrayList<>();

    @Override
    public Optional<Vehicle> save(final Vehicle vehicle) {
        vehicleList.add(vehicle);
        return Optional.of(vehicle);
    }

    @Override
    public Optional<Vehicle> findById(final Long tId) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getId().equals(tId)) {
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }

    @Override
    public Vehicle[] findAll() {
        Vehicle[] vehicles = new Vehicle[vehicleList.size()];
        int i = 0;
        for (Vehicle vehicle : vehicleList) {
            vehicles[i].setId(vehicle.getId());
            vehicles[i].setBrand(vehicle.getBrand());
            vehicles[i].setReleaseDate(vehicle.getReleaseDate());
            vehicles[i].setModel(vehicle.getModel());
            vehicles[i].setMileage(vehicle.getMileage());
            vehicles[i].setAutoParkId(vehicle.getAutoParkId());
            vehicles[i].setId(vehicle.getId());
            i++;
        }
        return vehicles;
    }

    @Override
    public boolean deleteById(final Long tId) {
        return vehicleList.remove(tId);
    }

    @Override
    public Vehicle update(final Vehicle vehicle) {
        for (Vehicle vehicle1: vehicleList) {
            vehicle1.setId(vehicle.getId());
            vehicle1.setBrand(vehicle.getBrand());
            vehicle1.setReleaseDate(vehicle.getReleaseDate());
            vehicle1.setModel(vehicle.getModel());
            vehicle1.setMileage(vehicle.getMileage());
            vehicle1.setAutoParkId(vehicle.getAutoParkId());
            vehicle1.setId(vehicle.getId());
            return vehicle1;
        }
        return new Vehicle();
    }
}
