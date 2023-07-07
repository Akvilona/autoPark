package ru.autopark;

import ru.autopark.model.AutoPark;
import ru.autopark.model.Customer;
import ru.autopark.model.Vehicle;
import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

public final class App {
    private App() {

    }

    public static void main(final String[] args) {
    }

    private static AutoPark getAutoPark() {
        AutoPark autoPark = new AutoPark();
        autoPark.setId(2L);
        autoPark.setName("AutoParkName");
        return autoPark;
    }

    private static Optional<Customer> getCustomer() {
        if (new Random().nextBoolean()) {
            Customer customer = new Customer();
            customer.setId(new Random().nextLong());
            customer.setName("name1");
            customer.setPhone("1234");
            customer.setAddress("setAddress");

            return Optional.of(customer);
        } else {
            Optional<Customer> optionalCustomer = Optional.empty();
            return optionalCustomer;
        }
    }

    private static Customer getAnotherCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("new Name");
        customer.setPhone("new Phome");
        customer.setAddress("new Address");
        return customer;
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

