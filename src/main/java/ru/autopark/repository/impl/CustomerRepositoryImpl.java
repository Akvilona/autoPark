/**
 * ������ ������ ������� 29.06.2023 8:24
 **/
package ru.autopark.repository;

import ru.autopark.model.Customer;
import java.util.Objects;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Customer[] customers = new Customer[50];
    private final Customer customer = new Customer();

    @Override /** добавление пользователя в список автопарка */
    public Customer[] add(Long id, String name, Long autoParkId) {

        Customer customer = new Customer(id, name, autoParkId);

        for (int i = 0; i < customers.length; i++) {
            if (Objects.isNull (customers[i])){
                customers[i] = customer;
            }
        }
        return customers;
    }

    @Override /** получение всех пользователей автопарке */
    public Customer[] findAll() {
        return customers;
    }

    @Override /** удаление пользователя из автопарка  */
    public Customer[] deleteName(String name) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getName() == name){
                customers[i] = customer;
            }
        }
        return customers;
    }

    @Override /** наличие пользователя в автопарке */
    public Boolean findName(String name) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getName() == name){
                return true;
            }
        }
        return false;
    }
}