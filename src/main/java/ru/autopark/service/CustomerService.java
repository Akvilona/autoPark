package ru.autopark.service;

import ru.autopark.model.Customer;

public interface CustomerService {
    Customer findById(long customerId);

    Customer save(Customer customer);

    Customer findByNameAndPhone(String name, String phone);

    Customer[] findAll();

    Customer update(Customer customer);
}
