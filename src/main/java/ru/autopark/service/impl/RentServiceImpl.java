package ru.autopark.service.impl;

import ru.autopark.exception.RentNotFoundException;
import ru.autopark.model.Customer;
import ru.autopark.model.Rent;
import ru.autopark.repository.RentRepository;
import ru.autopark.service.CustomerService;
import ru.autopark.service.RentService;

import java.util.Optional;

public class RentServiceImpl implements RentService {

    private final CustomerService customerService;
    private final RentRepository rentRepository;

    public RentServiceImpl(final CustomerService customerService,
                           final RentRepository rentRepository) {
        this.customerService = customerService;
        this.rentRepository = rentRepository;
    }

    @Override
    public Optional<Rent> findById(final long rentId) {
        Optional<Rent> rent1 = rentRepository.findById(rentId);
        if (rent1.isEmpty()) {
            throw new RentNotFoundException("Cant find RentId" + rentId);
        }
        return Optional.of(rent1.get());
    }

    @Override
    public Optional<Rent> findByCustomerName(final String name, final String phone) {
        Optional<Customer> customer = customerService.findByNameAndPhone(name, phone);
        Optional<Rent> rent = rentRepository.findByCustomerId(customer.get().getId());
        if (rent == null) {
            throw new IllegalArgumentException("Cant find rent by customer name and phone: " + customer);
        }
        return rent;
    }

    @Override
    public Optional<Rent> save(final Rent rent) {
        Optional<Rent> rent1 = rentRepository.save(rent);
        if (rent1 == null) {
            throw new RentNotFoundException("Cant find Rent" + rent);
        }
        return rent1;
    }

    @Override
    public Optional<Rent> findByCustomerId(final long customerId) {
        Optional<Customer> customer = customerService.findById(customerId);
        Optional<Rent> rent = rentRepository.findByCustomerId(customer.get().getId());
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
    public Optional<Boolean> deleteById(final long rentId) {
        if (!rentRepository.deleteById(rentId)) {
            throw new IllegalArgumentException("Cant find rent id: " + rentId);
        } else {
            return Optional.of(false);
        }
    }

    @Override
    public Optional<Rent> update(final Rent rent) {
        Optional<Rent> update = update(rent);
        if (update == null) {
            throw new IllegalArgumentException("Cant update rent: " + rent);
        }
        return update;
    }
}
