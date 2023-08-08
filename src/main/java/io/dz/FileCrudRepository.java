package io.dz;

import io.User;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class FileCrudRepository implements CrudRepository<User> {

    private final File file;

    public FileCrudRepository(File file) {
        this.file = file;
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }

    //TODO: equals and hash code
    @Override
    public Optional<User> findByObject(User user) {
        return Optional.empty();
    }

    //TODO: check if user not exist
    @Override
    public void save(User user) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
