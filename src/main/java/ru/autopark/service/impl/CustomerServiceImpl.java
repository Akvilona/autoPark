package ru.autopark.service.impl;

import ru.autopark.exception.CustomerNotFoundExcepton;
import ru.autopark.model.Customer;
import ru.autopark.repository.CustomerRepository;
import ru.autopark.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(long customerId) {
        Customer customer = customerRepository.findById(customerId);
        if (customer == null) {
            throw new CustomerNotFoundExcepton("Cant find customer with id: " + customerId);
        }
        return customer;
    }

    @Override
    public Customer findByNameAndPhone(String name, String phone) {
        Customer customer = customerRepository.findByNameAndPhone(name, phone);
        if (customer == null) {
            throw new CustomerNotFoundExcepton("Cant find customer with name: " + name);
        }
        return customer;
    }

    @Override
    public Customer save(Customer customer) {
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
