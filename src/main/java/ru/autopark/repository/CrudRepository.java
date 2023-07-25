package ru.autopark.repository;

import java.util.Optional;

public interface CrudRepository<T> {

    Optional<T> save(T t);

    Optional<T> findById(Long tId);

    T[] findAll();

    boolean deleteById(Long tId);

    T update(T t);
}
