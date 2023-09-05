package nio.dz;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, K> {

    Optional<T> findById(K id);

    void save(T t);

    void delete(K id);

    List<T> findAll();
}
