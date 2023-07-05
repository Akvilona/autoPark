/**
 * Создал Андрей Антонов 02.07.2023 19:33
 **/
package ru.autopark.repository;

import ru.autopark.model.Rent;

import java.time.Duration;
import java.time.LocalDateTime;

public interface RentRepository {

    Rent add(Long vehicleId, Long customerId, Long autoParkId, LocalDateTime createDateTime, Duration duration);

    long delete(long index);

    Rent[] findRentsByAutoParkId(Long autoParkId);

    Rent[] findRentsByCustomerId(Long customerId);

}
