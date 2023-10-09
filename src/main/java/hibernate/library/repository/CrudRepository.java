<<<<<<<< HEAD:src/main/java/hibernate/libraly/repository/CrudRepository.java
package hibernate.libraly.repository;
========
package hibernate.library.repository;
>>>>>>>> origin/master:src/main/java/hibernate/library/repository/CrudRepository.java

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, K> {
    T save(T t);

    void delete(K id);

    List<T> findAll();

    Optional<T> findById(K id);

}
