package ru.autopark.service.impl;

import ru.autopark.exception.CustomerNotFoundExcepton;
import ru.autopark.model.Customer;
import ru.autopark.repository.CustomerRepository;
import ru.autopark.service.CustomerService;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(final long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundExcepton("Cant find customer with id: " + customerId));
    }

    @Override
    public Customer findByNameAndPhone(final String name, final String phone) {
        Customer customer = customerRepository.findByNameAndPhone(name, phone);
        if (customer == null) {
            throw new CustomerNotFoundExcepton("Cant find customer with name: " + name);
        }
        return customer;
    }

    @Override
    public Customer save(final Customer customer) {
        Customer save = customerRepository.save(customer);
        if (save == null) {
            throw new CustomerNotFoundExcepton("Cant find customer with customer: " + customer);
        }
        return save;
    }

    @Override
    public Customer[] findAll() {
        return customerRepository.findAll();
    }
}
