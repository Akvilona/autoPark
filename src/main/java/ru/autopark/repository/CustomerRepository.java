/**
 * ������ ������ ������� 29.06.2023 8:18
 **/
package ru.autopark.repository;

import ru.autopark.model.Customer;

import java.util.Optional;

public interface CustomerRepository {

    Customer save(Customer customer, int index);

    //Опционально
    Customer findByNameAndPhone(String name, String phone);

    Optional<Customer> findById(long customerId);

    Customer[] findAll();

    boolean deleteById(long customerId);

}
