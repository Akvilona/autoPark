package ru.autopark.service;

import ru.autopark.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findById(long customerId);

    Optional<Customer> save(Customer customer);

    Optional<Customer> findByNameAndPhone(String name, String phone);

    Customer[] findAll();
}
