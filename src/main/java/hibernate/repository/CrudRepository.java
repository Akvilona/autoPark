package hibernate.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, K> {
    T save(T t);

    void delete(K id);

    List<T> findAll();

    Optional<T> findById(K id);

}
