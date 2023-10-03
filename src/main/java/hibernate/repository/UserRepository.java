package hibernate.repository;

import hibernate.entity.User;

import java.util.List;
import java.util.Optional;

public class UserRepository implements CrudRepository<User, Long> {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }
}
