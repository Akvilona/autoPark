package ru.autopark.service;

import ru.autopark.model.Rent;
import ru.autopark.repository.RentRepository;

public interface RentService {
    Rent findByCustomerName(String name, String phone);

    Rent save(Rent rent);

    Rent findById(long rentId);

    Rent findByCustomerId(long customerId);

    RentRepository findAll();

    boolean deleteById(long rentId);

    Rent update(Rent rent);
}
