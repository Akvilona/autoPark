package ru.autopark.service.impl;

import ru.autopark.exception.CustomerNotFoundExcepton;
import ru.autopark.model.Customer;
import ru.autopark.repository.CustomerRepository;
import ru.autopark.service.CustomerService;
import ru.autopark.util.Util;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundExcepton("Cant find customer with id: " + customerId));
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
        int index = Util.findEmptyIndex(customerRepository.findAll());
        if (index == -1) {
            throw new IllegalArgumentException("Array is full!");
        }
        return customerRepository.save(customer, index);
    }

    @Override
    public Customer[] findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getId());

        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundExcepton("Cant find customer with customer: " + customer);
        }

        Customer forUpdate = optionalCustomer.get();
        forUpdate.setAddress(customer.getAddress());
        forUpdate.setName(customer.getName());
        forUpdate.setPhone(customer.getPhone());

        return forUpdate;
    }
}
