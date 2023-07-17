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
    public Optional<Customer> findById(final long customerId) {
        return Optional.ofNullable(customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundExcepton("Cant find customer with id: " + customerId)));
    }

    @Override
    public Optional<Customer> findByNameAndPhone(final String name, final String phone) {
        Optional<Customer> customer = customerRepository.findByNameAndPhone(name, phone);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundExcepton("Cant find customer with name: " + name);
        }
        return customer;
    }

    @Override
    public Optional<Customer> save(final Customer customer) {
        Optional<Customer> save = customerRepository.save(customer);
        if (Optional.ofNullable(save).isEmpty()) {
            throw new CustomerNotFoundExcepton("Cant find customer with customer: " + customer);
        }
        return save;
    }

    @Override
    public Customer[] findAll() {
        return customerRepository.findAll();
    }
}
