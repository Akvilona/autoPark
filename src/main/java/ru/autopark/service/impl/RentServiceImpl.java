package ru.autopark.service.impl;

import ru.autopark.model.Customer;
import ru.autopark.model.Rent;
import ru.autopark.repository.RentRepository;
import ru.autopark.service.CustomerService;
import ru.autopark.service.RentService;

public class RentServiceImpl implements RentService {

    private final CustomerService customerService;
    private final RentRepository rentRepository;

    public RentServiceImpl(CustomerService customerService,
                           RentRepository rentRepository) {
        this.customerService = customerService;
        this.rentRepository = rentRepository;
    }

    @Override
    public Rent findByCustomerName(final String name, final String phone) {
        Customer customer = customerService.findByNameAndPhone(name, phone);
        Rent rent = rentRepository.findByCustomerId(customer.getId());
        if (rent == null) {
            throw new IllegalArgumentException("Cant find rent by customer id: " + customer.getId());
        }
        return rent;
    }
}
