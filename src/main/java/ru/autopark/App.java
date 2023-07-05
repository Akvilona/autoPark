package ru.autopark;

import ru.autopark.model.Customer;
import ru.autopark.repository.CustomerRepository;
import ru.autopark.repository.impl.CustomerRepositoryImpl;

import java.util.Arrays;

public class App {
    private App() {

    }
    public static void main(final String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        Customer customer = getCustomer();
        Customer save = customerRepository.save(customer);
        System.out.println("customerRepository.save: " + save);

        Customer byId = customerRepository.findById(1L);
        System.out.println("customerRepository.findById: " + byId);

        Customer[] customers = customerRepository.findAll();
        System.out.println("customerRepository.findAll: " + Arrays.toString(customers));

        boolean result = customerRepository.deleteById(1L);
        System.out.println("customerRepository.deleteById: " + result);

        Customer[] customers1 = customerRepository.findAll();
        System.out.println("customerRepository.findAll: " + Arrays.toString(customers1));

        customerRepository.save(getCustomer());

        System.out.println("customerRepository.findAll: "
                + Arrays.toString(customerRepository.findAll()));

        Customer update = getAnotherCustomer();
        customerRepository.update(update);

        System.out.println("customerRepository.findAll: "
                + Arrays.toString(customerRepository.findAll()));

    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("name1");
        customer.setPhone("1234");
        customer.setAddress("setAddress");
        return customer;
    }

    private static Customer getAnotherCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("new Name");
        customer.setPhone("new Phome");
        customer.setAddress("new Address");
        return customer;
    }
}
