package io.dz;

import io.User;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class FileCrudRepository implements CrudRepository<User> {
    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByObject(User user) {
        return Optional.empty();
    }

    @Override
    public void save(User user) throws IOException {

        Serial serial = new Serial();
        if (serial.serIn (user)) {
            System.out.println("Ok");
        };
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
