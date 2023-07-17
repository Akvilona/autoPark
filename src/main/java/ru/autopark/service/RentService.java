package ru.autopark.service;

import ru.autopark.model.Rent;
import ru.autopark.repository.RentRepository;

import java.util.Optional;

public interface RentService {
    Optional<Rent> findByCustomerName(String name, String phone);

    Optional<Rent> save(Rent rent);

    Optional<Rent> findById(long rentId);

    Optional<Rent> findByCustomerId(long customerId);

    RentRepository findAll();

    Optional<Boolean> deleteById(long rentId);

    Optional<Rent> update(Rent rent);
}
