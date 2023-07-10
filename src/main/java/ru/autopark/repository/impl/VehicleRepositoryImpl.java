/**
 * Создал Андрей Антонов 02.07.2023 13:04
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.Vehicle;
import ru.autopark.repository.VehicleRepository;
import ru.autopark.util.Util;

public class VehicleRepositoryImpl implements VehicleRepository {

    private static final int VEHICLECOUNT = 100;
    private static Vehicle[] vehicles = new Vehicle[VEHICLECOUNT]; // массив вместо таблицы базы данных

    @Override
    public Vehicle save(final Vehicle vehicle) {
        int index = Util.findEmptyIndex(vehicles);
        if (index == -1) {
            return null;
        }
        vehicles[index] = vehicle;
        return vehicle;
    }

//    @Override
//    public Vehicle findByAll(final Long id, final Brand brand, final Model model, final LocalDate releaseDate, final Integer mileage) {
//        for (Vehicle vehicle : vehicles) {
//            if (vehicle != null && vehicle.getBrand().equals(brand)
//                    && vehicle.getModel().equals(model)
//                    && vehicle.getReleaseDate().equals(releaseDate)
//                    && vehicle.getMileage().equals(mileage)) {
//                return vehicle;
//            }
//        }
//        return null;
//    }

    @Override
    public Vehicle findById(final long vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getId() == vehicleId) {
                return vehicle;
            }
        }
        return null;
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
    public Vehicle update(final Vehicle vehicle) {
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

