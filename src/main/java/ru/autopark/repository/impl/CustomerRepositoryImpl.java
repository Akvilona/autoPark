package ru.autopark.repository.impl;

import ru.autopark.model.Customer;
import ru.autopark.repository.CustomerRepository;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Customer[] customers = new Customer[50]; //  этот массив вместо базы данных

    @Override
    public long add(Long id,
                          String name,
                          String address,
                          String phone,
                          Long autoParkId) { /** добавление пользователя в автопарк */

        Customer customer = new Customer(id, name, address, phone, autoParkId);

        Long index = findEmptyIndex(customers);

        if (index == -1) {
            System.out.println("Customers arr is full");
            return -1;
        }
        customers[Math.toIntExact(index)] = customer;
        return index;
    }

    @Override /** поиск идентификатора */
    public long find(String name, String phone) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getName() == name ||
                customers[i].getPhone() == phone){
                return Long.valueOf(i);
            }
        }
        return -1;
    }

    @Override /** получение данных */
    public Customer get(long customerId) {
        Customer customer = new Customer();
        customer.setId(customers[(int) customerId].getId());
        customer.setName(customers[(int) customerId].getName());
        customer.setAddress(customers[(int) customerId].getAddress());
        customer.setPhone(customers[(int) customerId].getPhone());

        return customer;
    }

    @Override /** удаление */
    public long delete(long customerId) {
        Customer customer = new Customer();
        customers[(int) customerId] = customer;
        return 0;
    }

    public Customer[] deleteName(String name) { /** удаление пользователя из автопарка  */
        Customer customer = new Customer();
        for (long i = 0; i < customers.length; i++) {
            if (customers[(int) i].getName() == name) {
                customers[(int) i] = customer;
                return customers;
            }
        }
        return customers;
    }

    public Long findName(String name) { /** проверить наличие пользователя в автопарке */
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getName() == name) {
                return Long.valueOf(i);
            }
        }
        return null;
    }

    public static Long findEmptyIndex(Customer[] customers) { /** поиск первого свободного место в массиве пользователей  */
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                return Long.valueOf(i);
            }
        }
        return Long.valueOf(-1);
    }
}