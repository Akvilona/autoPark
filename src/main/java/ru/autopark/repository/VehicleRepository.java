/**
 * Создал Андрей Антонов 30.06.2023 10:47
 **/
package ru.autopark.repository;

import ru.autopark.model.Vehicle;
import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;

import java.time.LocalDate;

public interface VehicleRepository {

    Vehicle createVehicle(Long id,                // идентификатор
                          Brand brand,            // марка
                          Model model,            // модель
                          LocalDate releaseDate,  // год выпуска
                          Integer mileage,        // пробег
                          Long autoParkId);       // вторичный ключ

    Vehicle createVehicle();

    Vehicle[] findVehicle(Brand brand,            // марка
                          Model model,            // модель
                          LocalDate releaseDate,  // год выпуска
                          Integer mileage,        // пробег
                          Long autoParkId);       // вторичный ключ


    Vehicle[] deleteVehicle(Brand brand,            // марка
                            Model model,            // модель
                            LocalDate releaseDate,  // год выпуска
                            Integer mileage,        // пробег
                            Long autoParkId);       // вторичный ключ

    //    Customer save(Customer customer); //1
    //
    //    //Опционально
    //    Customer findByNameAndPhone(String name, String phone);
    //
    //    Customer findById(long customerId); //2
    //
    //    Customer[] findAll();
    //
    //    boolean deleteById(long customerId);//3
    //
    //    Customer update(Customer customer);//4
}
