/**
 * Создал Андрей Антонов 29.08.2023 7:19
 **/

package db.jdbc.library.service;

import db.jdbc.library.entity.User;
import db.jdbc.library.exception.ErrorCode;
import db.jdbc.library.exception.ServiceException;
import db.jdbc.library.repository.db.Userdbrepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserService {
    private final Userdbrepository dbRepository;

    public User save(final User user) {
        return dbRepository.save(user);
    }

    public void delete(final Long id) {
        dbRepository.delete(id);
    }

    public User findById(final Long id) {
        return dbRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_02, id));
    }

    public boolean exist(final Long id) {
        return dbRepository.findById(id).isPresent();
    }

    public List<User> findAll() {
        return dbRepository.findAll();
    }
}
