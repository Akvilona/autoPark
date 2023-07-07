package ru.autopark;

import ru.autopark.model.AutoPark;
import ru.autopark.model.Customer;
import ru.autopark.model.Vehicle;
import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;
import ru.autopark.repository.CustomerRepository;
import ru.autopark.repository.RentRepository;
import ru.autopark.repository.impl.CustomerRepositoryImpl;
import ru.autopark.repository.impl.RentRepositoryImpl;
import ru.autopark.service.CustomerService;
import ru.autopark.service.RentService;
import ru.autopark.service.impl.CustomerServiceImpl;
import ru.autopark.service.impl.RentServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public final class App {
    private App() {

    }

    public static void main(final String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerServiceImpl(customerRepository);

        RentRepository rentRepository = new RentRepositoryImpl();

        RentService rentService = new RentServiceImpl(customerService, rentRepository);

        customerService.save(getCustomer());
        customerService.save(getCustomer());
        customerService.save(getCustomer());
        customerService.save(getCustomer());
        customerService.save(getCustomer());

        System.out.println(Arrays.toString(customerService.findAll()));

//        rentService.findByCustomerName()

    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(new Random().nextLong());
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

    private static AutoPark getAutoPark() {
        AutoPark autoPark = new AutoPark();
        autoPark.setId(2L);
        autoPark.setName("AutoParkName");
        return autoPark;
    }

    private static AutoPark getAutoParkSecond() {
        final long autoParkId = 3L;
        AutoPark autoPark = new AutoPark();
        autoPark.setId(autoParkId);
        autoPark.setName("New AutoParkName");
        return autoPark;
    }

    private static Vehicle getVehicle() {
        final long mileage = 1000L;
        final long vehicleId = 1L;
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleId);
        vehicle.setBrand(Brand.valueOf("RENAULT"));
        vehicle.setModel(Model.valueOf("LOGAN"));
        vehicle.setReleaseDate(LocalDate.parse("2010-01-01"));
        vehicle.setMileage((int) mileage);
        vehicle.setAutoParkId(1L);

        return vehicle;
    }

}

