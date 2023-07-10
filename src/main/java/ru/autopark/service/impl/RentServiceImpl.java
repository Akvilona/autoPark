package ru.autopark.service.impl;

import ru.autopark.exception.RentNotFoundException;
import ru.autopark.model.Customer;
import ru.autopark.model.Rent;
import ru.autopark.repository.RentRepository;
import ru.autopark.service.CustomerService;
import ru.autopark.service.RentService;

public class RentServiceImpl implements RentService {

    private final CustomerService customerService;
    private final RentRepository rentRepository;

    public RentServiceImpl(final CustomerService customerService,
                           final RentRepository rentRepository) {
        this.customerService = customerService;
        this.rentRepository = rentRepository;
    }

    @Override
    public Rent findById(final long rentId) {
        Rent rent1 = rentRepository.findById(rentId);
        if (rent1 == null) {
            throw new RentNotFoundException("Cant find RentId" + rentId);
        }
        return rent1;
    }

    @Override
    public Rent findByCustomerName(final String name, final String phone) {
        Customer customer = customerService.findByNameAndPhone(name, phone);
        Rent rent = rentRepository.findByCustomerId(customer.getId());
        if (rent == null) {
            throw new IllegalArgumentException("Cant find rent by customer name and phone: " + customer);
        }
        return rent;
    }

    @Override
    public Rent save(final Rent rent) {
        Rent rent1 = rentRepository.save(rent);
        if (rent1 == null) {
            throw new RentNotFoundException("Cant find Rent" + rent);
        }
        return rent1;
    }

    @Override
    public Rent findByCustomerId(final long customerId) {
        Customer customer = customerService.findById(customerId);
        Rent rent = rentRepository.findByCustomerId(customer.getId());
        if (rent == null) {
            throw new IllegalArgumentException("Cant find rent by customer id: " + customerId);
        }
        return rent;
    }

    @Override
    public RentRepository findAll() {
        return this.rentRepository;
    }

    @Override
    public boolean deleteById(final long rentId) {
        if (!rentRepository.deleteById(rentId)) {
            throw new IllegalArgumentException("Cant find rent id: " + rentId);
        } else {
            return false;
        }
    }

    @Override
    public Rent update(final Rent rent) {
        Rent update = update(rent);
        if (update == null) {
            throw new IllegalArgumentException("Cant update rent: " + rent);
        }
        return null;
    }
}
