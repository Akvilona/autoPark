package io.dz;

import io.User;

import java.io.IOException;
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

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
