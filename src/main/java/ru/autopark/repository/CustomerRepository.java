/**
 * ������ ������ ������� 29.06.2023 8:18
 **/
package ru.autopark.repository;

import ru.autopark.model.Customer;
import ru.autopark.model.Rent;

import javax.naming.Name;

public interface CustomerRepository {

    long add(Long id, String name, String address, String phone, Long autoParkId);

    long find(String name, String phone);

    Customer get(long customerId);

    long delete(long customerId);

}
