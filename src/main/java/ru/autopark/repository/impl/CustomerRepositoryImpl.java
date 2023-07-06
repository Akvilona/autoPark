package ru.autopark.repository.impl;

import ru.autopark.model.Customer;
import ru.autopark.repository.CustomerRepository;
import ru.autopark.util.Util;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final int CUSTOMERS_COUNT = 50;
    private final Customer[] customers = new Customer[CUSTOMERS_COUNT];


    @Override
    public Customer save(final Customer customer) {
        int index = Util.findEmptyIndex(customers);
        if (index == -1) {
            return null;
        }
        customers[index] = customer;
        return customer;
    }

    @Override
    public Customer findByNameAndPhone(final String name, final String phone) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name) && customer.getPhone().equals(phone)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer findById(final long customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(final long customerId) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId() == customerId) {
                customers[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Customer update(final Customer customer) {
        Customer customerForUpdate = findById(customer.getId());
        customerForUpdate.setAddress(customer.getAddress());
        customerForUpdate.setName(customer.getName());
        customerForUpdate.setPhone(customer.getPhone());
        return customerForUpdate;
    }

    @Override
    public Customer[] findAll() {
        return this.customers;
    }
}
