package ru.autopark.repository.impl;

import ru.autopark.model.Customer;
import ru.autopark.repository.CustomerRepository;
import ru.autopark.util.Util;

import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final int CUSTOMERS_COUNT = 50;
    private final Customer[] customers = new Customer[CUSTOMERS_COUNT];

    @Override
    public Optional<Customer> save(final Customer customer) {
        int index = Util.findEmptyIndex(customers);
        if (index == -1) {
            return Optional.empty();
        }
        customers[index] = customer;
        return Optional.of(customer);
    }

    @Override
    public Optional<Customer> findByNameAndPhone(final String name, final String phone) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name) && customer.getPhone().equals(phone)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Customer> findById(final Long customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(final Long customerId) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId().equals(customerId)) {
                customers[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Customer update(final Customer customer) {
        Optional<Customer> customerForUpdate = findById(customer.getId());
        Customer customer1 = customerForUpdate.get();
        customer1.setAddress(customer.getAddress());
        customer1.setName(customer.getName());
        customer1.setPhone(customer.getPhone());
        return customer1;
    }

    @Override
    public Customer[] findAll() {
        return this.customers;
    }

}
