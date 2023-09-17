/**
 * Создал Андрей Антонов 29.08.2023 7:19
 **/
package library.service;

import library.exception.ErrorCode;
import library.exception.ServiceException;
import library.model.User;
import library.repository.UserDBRepository;

import java.util.List;

public class UserService {
    private final UserDBRepository userDBRepository;

    public UserService(final UserDBRepository userDBRepository) {
        this.userDBRepository = userDBRepository;
    }

    public void save(final User user) {
        userDBRepository.save(user);
    }

    public void delete(final Long id) {
        userDBRepository.delete(id);
    }

    public User findById(final Long id) {
        return userDBRepository.findById(id)
                .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_02, id));
    }

    public boolean exist(final Long id) {
        return userDBRepository.findById(id).isPresent();
    }

    public List<User> findAll() {
        return userDBRepository.findAll();
    }
}
