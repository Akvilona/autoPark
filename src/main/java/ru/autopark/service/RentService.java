package ru.autopark.service;

import ru.autopark.model.Rent;

public interface RentService {
    Rent findByCustomerName(String name, final String phone);
}
