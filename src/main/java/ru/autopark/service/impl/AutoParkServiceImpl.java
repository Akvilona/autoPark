/**
 * Создал Андрей Антонов 10.07.2023 19:33
 **/
package ru.autopark.service.impl;

import ru.autopark.exception.AutoParkNotFoundException;
import ru.autopark.model.AutoPark;
import ru.autopark.repository.AutoParkRepository;
import ru.autopark.service.AutoParkService;

public class AutoParkServiceImpl implements AutoParkService {
    private final AutoParkRepository autoParkRepository;

    public AutoParkServiceImpl(final AutoParkRepository autoParkRepository) {
        this.autoParkRepository = autoParkRepository;
    }

    @Override
    public AutoPark save(final AutoPark autoPark) {
        AutoPark autoPark1 =  autoParkRepository.save(autoPark);
        if (autoPark1 == null) {
            throw new AutoParkNotFoundException("Cant find AutoPark:" + autoPark);
        }
        return autoPark1;
    }

    @Override
    public AutoPark findByName(final String name) {
        AutoPark autoPark = autoParkRepository.findByName(name);
        if (autoPark == null) {
            throw new AutoParkNotFoundException("Cant find AutoPark: " + name);
        }
        return autoPark;
    }

    @Override
    public AutoPark findById(final long autoParkId) {
        AutoPark autoPark = autoParkRepository.findById(autoParkId);
        if (autoPark == null) {
            throw new AutoParkNotFoundException("Cant find AutoParkId: " + autoParkId);
        }
        return autoPark;
    }

    @Override
    public AutoPark[] findAll() {
        AutoPark[] autoPark = autoParkRepository.findAll();
        if (autoPark == null) {
            throw new AutoParkNotFoundException("Cant find List AutoPark[]");
        }
        return autoPark;
    }

    @Override
    public boolean deleteById(final long customerId) {
        if (!autoParkRepository.deleteById(customerId)) {
            throw new AutoParkNotFoundException("Cant delete AutoPark by customerId: " + customerId);
        }
        return true;
    }

    @Override
    public AutoPark update(final AutoPark autoPark) {
        AutoPark autoPark1 = autoParkRepository.update(autoPark);
        if (autoPark1 == null) {
            throw new AutoParkNotFoundException("Cant update AutoPark: " + autoPark);
        }
        return autoPark1;
    }
}
