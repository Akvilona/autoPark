/**
 * Создал Андрей Антонов 29.08.2023 6:49
 **/
package library.repository;

import library.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> userList = new ArrayList<>();

    public void addUser(final User user) {
        userList.add(user);
    }

    public void removeUser(final User user) {

    }

    public Integer getUserByName(final String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user.getId();
            }
        }
        return null;
    }

    public Optional<User> getUserById(final Integer id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
