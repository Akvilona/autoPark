/**
 * Создал Андрей Антонов 02.07.2023 13:04
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.Vehicle;
import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;
import ru.autopark.repository.VehicleRepository;

import java.time.LocalDate;

public class VehicleRepositoryImpl implements VehicleRepository {

    private static Vehicle[] vehicles = new Vehicle[100]; // массив вместо таблицы базы данных

    @Override
    public Vehicle createVehicle(Long id, Brand brand, Model model, LocalDate releaseDate, Integer mileage, Long autoParkId) {

        Vehicle vehicle = new Vehicle(id, brand, model, releaseDate, mileage, autoParkId);

        long index = findEmptyIndex();
        if (index == -1) {
            System.out.println("Vehicle is full");
            return null;
        }

        vehicles[Math.toIntExact(index)] = vehicle;

        return vehicle;
    }

    @Override
    public Vehicle createVehicle() {
        return createVehicle(null, null, null, null, null, null);
    }

    @Override
    /** поиск транспортного средства по критериям */
    public Vehicle[] findVehicle(Brand brand, Model model, LocalDate releaseDate, Integer mileage, Long autoParkId) {

        Vehicle[] vehicle = new Vehicle[(int) 100];
        int[] ret = new int[100];
        ret = findVehicleArray(brand, model, releaseDate, mileage, autoParkId); // получение списка идентификаторов подходящих по критериям
        if (ret.length > 0) {
            for (int i = 0; i < ret.length; i++) {
                vehicle[ret[i]] = getVehicleDescription(i);
            }
        }
        return vehicle;
    }

    @Override
    /** удаление транспортного средства */
    public Vehicle[] deleteVehicle(Brand brand, Model model, LocalDate releaseDate, Integer mileage, Long autoParkId) {
        Vehicle vehicle = new Vehicle();

        int ret[] = new int[100];
        ret = findVehicleArray(brand, model, releaseDate, mileage, autoParkId); /** получение списка идентификаторов подходящих по критериям */
        if (ret.length > 0) {
            for (int i = 0; i < ret.length; i++) {
                vehicles[ret[i]] = vehicle;
            }
        }

        return new Vehicle[0];
    }

    public long findEmptyIndex() { /** поиск первого пустого */
        for (Long i = 1L; i < this.vehicles.length; i++) {
            if (vehicles[Math.toIntExact(i)] == null) {
                return i;
            }
        }
        return -1;
    }

    public static Vehicle getVehicleDescription(long id) { /** возвращает одно транспортное средство по идентификатору */
        Vehicle vehicle = new Vehicle();
        if (id > -1) {
            vehicle.setBrand(vehicles[(int) id].getBrand());
            vehicle.setModel(vehicles[(int) id].getModel());
            vehicle.setReleaseDate(vehicles[(int) id].getReleaseDate());
            vehicle.setMileage(vehicles[(int) id].getMileage());
            vehicle.setAutoParkId(vehicles[(int) id].getAutoParkId());
        }
        return vehicle;
    }

    public static int[] findVehicleArray(Brand brand, Model model, LocalDate releaseDate, Integer mileage, Long autoParkId) {
        int ret[] = new int[100]; /** получение массива идентификаторов транспортных средств подходящих по критериям запроса */
        int j = 0;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[(int) i].getAutoParkId() == autoParkId || autoParkId == null) {
                if (vehicles[(int) i].getBrand() == brand || brand == null) {
                    if (vehicles[(int) i].getModel() == model || model == null) {
                        if (vehicles[(int) i].getReleaseDate() == releaseDate || releaseDate == null) {
                            if (vehicles[(int) i].getMileage() == mileage || mileage == null) {
                                ret[j] = i;
                                j = j++;
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

}
