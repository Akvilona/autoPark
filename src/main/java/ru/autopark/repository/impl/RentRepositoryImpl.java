/**
 * Создал Андрей Антонов 02.07.2023 20:27
 **/
package ru.autopark.repository.impl;

import ru.autopark.model.Rent;
import ru.autopark.repository.RentRepository;

import java.time.Duration;
import java.time.LocalDateTime;

public class RentRepositoryImpl implements RentRepository {

    private final Rent[] rents = new Rent[50]; //  этот массив вместо базы данных

    @Override
    public Rent add(Long vehicleId, Long customerId, Long autoParkId, LocalDateTime createDateTime, Duration duration) {

        Rent rent = new Rent(vehicleId, customerId, autoParkId, createDateTime, duration);

        Long index = findEmptyIndex(rents);

        if (index == -1) {
            System.out.println("Rent arr is full");
            return null;
        }
        rents[Math.toIntExact(index)] = rent;
        return rent;
    }

    @Override
    public long delete(long index) {
        Rent rent = new Rent();
        rents[Math.toIntExact(index)] = rent;
        return 1;
    }

    @Override
    public Rent[] findAutoPark(Long autoParkId) {
        final Rent[] rents1 = new Rent[50]; //  этот выходной массив
        int j = 0;
        for (int i = 0; i < rents.length; i++) {
            if (rents[i].getAutoParkId() == autoParkId) {
                rents1[j] = rents[i];
                j = j++;
            }
        }
        return rents1;
    }

    @Override
    public Rent[] findCustomer(Long customerId) {
        final Rent[] rents1 = new Rent[50]; //  этот выходной массив
        int j = 0;
        for (int i = 0; i < rents.length; i++) {
            if (rents[i].getCustomerId() == customerId) {
                rents1[j] = rents[i];
                j = j++;
            }
        }
        return rents1;
    }

    public static Long findEmptyIndex(Rent[] rents) { /** поиск первого свободного место в массиве пользователей  */
        for (int i = 0; i < rents.length; i++) {
            if (rents[i] == null) {
                return Long.valueOf(i);
            }
        }
        return Long.valueOf(-1);
    }
}