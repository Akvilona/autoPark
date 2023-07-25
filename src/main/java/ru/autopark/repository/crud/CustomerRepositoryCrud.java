/**
 * Создал Андрей Антонов 23.07.2023 12:46
 **/
package ru.autopark.repository.crud;

import ru.autopark.model.Customer;
import ru.autopark.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryCrud implements CrudRepository<Customer> {
    private final List<Customer> customerList = new ArrayList<>();

    @Override
    public Optional<Customer> save(final Customer customer) {
        customerList.add(customer);
        return Optional.empty();
    }

    @Override
    public Optional<Customer> findById(final Long tId) {
        for (Customer customer: customerList) {
            if (customer.getId().equals(tId)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public Customer[] findAll() {
        Customer[] customers = new Customer[customerList.size()];
        int i = 0;
        for (Customer customer: customerList) {
            customers[i].setId(customer.getId());
        }
        return customers;
    }

    @Override
    public boolean deleteById(final Long tId) {
        return customerList.remove(tId);
    }

    @Override
    public Customer update(final Customer customer) {
        for (Customer customer1: customerList) {
            if (customer1.getId().equals(customer.getId())) {
                customer1.setName(customer.getName());
                customer1.setAddress(customer.getAddress());
                customer1.setPhone(customer.getPhone());
                return customer1;
            }
        }
        return new Customer();
    }
}
