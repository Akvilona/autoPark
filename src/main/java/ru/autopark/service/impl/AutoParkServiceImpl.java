/**
 * Создал Андрей Антонов 10.07.2023 19:33
 **/
package ru.autopark.service.impl;

import ru.autopark.exception.AutoParkNotFoundException;
import ru.autopark.model.AutoPark;
import ru.autopark.repository.AutoParkRepository;
import ru.autopark.service.AutoParkService;

import java.util.Optional;

public class AutoParkServiceImpl implements AutoParkService {
    private final AutoParkRepository autoParkRepository;

    public AutoParkServiceImpl(final AutoParkRepository autoParkRepository) {
        this.autoParkRepository = autoParkRepository;
    }

    @Override
    public Optional<AutoPark> save(final AutoPark autoPark) {
        Optional<AutoPark> autoPark1 =  autoParkRepository.save(autoPark);
        if (autoPark1.isEmpty()) {
            throw new AutoParkNotFoundException("Cant find AutoPark:" + autoPark);
        }
        return autoPark1;
    }

    @Override
    public Optional<AutoPark> findByName(final String name) {
        Optional<AutoPark> autoPark = autoParkRepository.findByName(name);
        if (autoPark.isEmpty()) {
            throw new AutoParkNotFoundException("Cant find AutoPark: " + name);
        }
        return autoPark;
    }

    @Override
    public Optional<AutoPark> findById(final long autoParkId) {
        Optional<AutoPark> autoPark = autoParkRepository.findById(autoParkId);
        return Optional.of(autoPark.get());
    }

    @Override
    public AutoPark[] findAll() {
        AutoPark[] autoPark = autoParkRepository.findAll().toArray(new AutoPark[0]);
        if (autoPark == null) {
            throw new AutoParkNotFoundException("Cant find List AutoPark[]");
        }
        return autoPark;
    }

    @Override
    public Optional<Boolean> deleteById(final long customerId) {
        if (!autoParkRepository.deleteById(customerId)) {
            throw new AutoParkNotFoundException("Cant delete AutoPark by customerId: " + customerId);
        }
        return Optional.of(true);
    }

    @Override
    public Optional<AutoPark> update(final AutoPark autoPark) {
        Optional<AutoPark> autoPark1 = autoParkRepository.update(autoPark);
        if (autoPark1.isEmpty()) {
            throw new AutoParkNotFoundException("Cant update AutoPark: " + autoPark);
        }
        return autoPark1;
    }
}
