package ru.autopark;

import ru.autopark.model.AutoPark;
import ru.autopark.model.Customer;
import ru.autopark.model.Vehicle;
import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;
import ru.autopark.repository.AutoParkRepository;
import ru.autopark.repository.CustomerRepository;
import ru.autopark.repository.VehicleRepository;
import ru.autopark.repository.impl.AutoParkRepositoryImpl;
import ru.autopark.repository.impl.CustomerRepositoryImpl;
import ru.autopark.repository.impl.VehicleRepositoryImpl;

import java.time.LocalDate;
import java.util.Arrays;

public final class App {
    private App() {

    }
    public static void main(final String[] args) {


        VehicleRepository vehicleRepository = new VehicleRepositoryImpl();
        Vehicle vehicle = getVehicle();
        Vehicle vehicle1 = vehicleRepository.save(vehicle);
        if (vehicle1.equals(vehicle)){
            System.out.println("Vehicle: true" );
        } else {
            System.out.println("Vehicle: false" );
        }
        Vehicle vehicle2 = vehicleRepository.findById(22);
        System.out.println("vehicleRepository.findById Find Vehicle: " + vehicle2);
        System.out.println("vehicleRepository.findByAll: " + vehicleRepository.findByAll(1L,
                Brand.valueOf("RENAULT"),
                Model.valueOf("LOGAN"),
                LocalDate.parse("2010-01-01"), 1000));

        vehicle.setBrand(Brand.valueOf("RENAULT"));
        vehicle.setModel(Model.valueOf("LOGAN"));
        vehicle.setReleaseDate(LocalDate.parse("2010-01-01"));
        vehicle.setMileage(1000);
        vehicle.setAutoParkId(1L);

        AutoParkRepository autoParkRepository = new AutoParkRepositoryImpl();
        AutoPark autoPark = getAutoPark();

        AutoPark autoParkSave = autoParkRepository.save (autoPark);
        System.out.println("autoParkRepository.save: " + autoParkSave );

        AutoPark autoParkSave2 = autoParkRepository.findByName("AutoParkName");
        System.out.println("autoParkSave2.findByName: " + autoParkSave2 );

        AutoPark autoParkBiId = autoParkRepository.findById(2);
        System.out.println("autoParkRepository.findById: " + autoParkBiId );

        AutoPark autoParkSave3 = autoParkRepository.save (getAutoParkSecond());
        System.out.println("autoParkRepository.save(second) " + autoParkSave3 );

        System.out.println("Find by Name in autoPark " +  autoParkRepository.findByName("dfdf"));
        System.out.println("Find by Id in autoPark " +  autoParkRepository.findById(2));

        // deleting an entry in AutoPark
        System.out.println("Delete autoPark " +  autoParkRepository.deleteById(2));


        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        Customer customer = getCustomer();
        Customer customerSave = customerRepository.save(customer);
        customerSave = customerRepository.save(customer);
        System.out.println("customerRepository.save: " + customerSave);

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

    private static AutoPark getAutoPark () {
        AutoPark autoPark = new AutoPark();
        autoPark.setId(2L);
        autoPark.setName("AutoParkName");
        return autoPark;
    }
    private static AutoPark getAutoParkSecond () {
        AutoPark autoPark = new AutoPark();
        autoPark.setId(3L);
        autoPark.setName("New AutoParkName");
        return autoPark;
    }

    private static Vehicle getVehicle () {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setBrand(Brand.valueOf("RENAULT"));
        vehicle.setModel(Model.valueOf("LOGAN"));
        vehicle.setReleaseDate(LocalDate.parse("2010-01-01"));
        vehicle.setMileage(1000);
        vehicle.setAutoParkId(1L);

        return vehicle;
    }

}

