/**
 * ������ ������ ������� 29.06.2023 8:18
 **/
package ru.autopark.repository;

import ru.autopark.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer> {
    //Опционально
    Customer findByNameAndPhone(String name, String phone);

}
