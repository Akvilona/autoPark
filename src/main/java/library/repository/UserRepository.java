/**
 * Создал Андрей Антонов 29.08.2023 6:49
 **/
package library.repository;

import library.model.User;
import nio.dz.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements CrudRepository<User, Long> {
    private final List<User> userList = new ArrayList<>();

    @Override
    public Optional<User> findById(final Long id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public User save(final User user) {
        userList.add(user);
        return user;
    }

    @Override
    public void delete(final Long id) {
        userList.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public List<User> findAll() {
        return userList;
    }
}
