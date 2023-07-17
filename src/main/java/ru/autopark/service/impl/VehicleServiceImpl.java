/**
 * Создал Андрей Антонов 10.07.2023 18:36
 **/
package ru.autopark.service.impl;

import ru.autopark.exception.AutoParkNotFoundException;
import ru.autopark.exception.VehicleNotFoundException;
import ru.autopark.model.Vehicle;
import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;
import ru.autopark.repository.impl.VehicleRepositoryImpl;
import ru.autopark.service.VehicleService;

import java.time.LocalDate;
import java.util.Optional;

public class VehicleServiceImpl implements VehicleService {
    private VehicleRepositoryImpl vehicleRepository;

    @Override
    public Optional<Vehicle> save(final Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        if (vehicle == null) {
            throw new VehicleNotFoundException("Cant find Vehicle with id: " + vehicle);
        }
        return Optional.of(vehicle);
    }

    @Override
    public Optional<Vehicle> findById(final long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
        if (vehicle == null) {
            throw new VehicleNotFoundException("Cant find Vehicle with id: " + vehicleId);
        }
        return Optional.of(vehicle);
    }

    @Override
    public Vehicle[] findAll() {
        Vehicle[] vehicle = vehicleRepository.findAll();
        if (vehicle == null) {
            throw new AutoParkNotFoundException("Cant find all vehicle in service ");
        }
        return vehicle;
    }

    @Override
    public Vehicle[] findAll(final Long id, final Brand brand, final Model model, final LocalDate releaseDate, final Integer mileage) {
        Vehicle[] vehicle = vehicleRepository.findAll();
        if (vehicle == null) {
            throw new AutoParkNotFoundException("Cant find all vehicle in service ");
        }
        return vehicle;
    }

    @Override
    public Optional<Boolean> deleteById(final long vehicleId) {
        if (!vehicleRepository.deleteById(vehicleId)) {
            return Optional.of(false);
//            throw new VehicleNotFoundException("Cant delete Vehicle with id: " + vehicleId);
        }
        return Optional.of(true);
    }

    @Override
    public Optional<Vehicle> update(final Vehicle vehicle) {
        Optional<Vehicle> vehicle1 = vehicleRepository.update(vehicle);
        if (vehicle1 == null) {
            throw new VehicleNotFoundException("Cant find Vehicle with id: " + vehicle);
        }
        return vehicle1;
    }
}
