/**
 * Создал Андрей Антонов 29.08.2023 7:19
 **/
package library.service;

import library.model.User;
import library.repository.UserRepository;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(final User user) {
        userRepository.save(user);
    }

    public User findById(final Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new RuntimeException("user not found exception");
    }

}
