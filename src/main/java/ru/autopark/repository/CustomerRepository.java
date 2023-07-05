/**
 * ������ ������ ������� 29.06.2023 8:18
 **/
package ru.autopark.repository;

import ru.autopark.model.Customer;

public interface CustomerRepository {

    Customer save(Customer customer);

    //Опционально
    Customer findByNameAndPhone(String name, String phone);

    Customer findById(long customerId);

    Customer[] findAll();

    boolean deleteById(long customerId);

    Customer update(Customer customer);

}
