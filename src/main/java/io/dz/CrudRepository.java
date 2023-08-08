package io.dz;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    Optional<T> findById(long id);

    Optional<T> findByObject(T t);

    void save(T t);

    void delete(long id);

    List<T> findAll();
}
