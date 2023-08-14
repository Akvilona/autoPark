package io.dz;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    Optional<T> findById(long id) throws IOException;

    Optional<T> findByObject(T t) throws IOException;

    void save(T t) throws IOException;

    void delete(long id) throws IOException;

    List<T> findAll() throws IOException;
}
