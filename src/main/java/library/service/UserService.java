/**
 * Создал Андрей Антонов 29.08.2023 7:19
 **/
package library.service;

import library.exception.ErrorCode;
import library.exception.ServiceException;
import library.model.User;
import library.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(final User user) {
        userRepository.save(user);
    }

    public User findById(final Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_02, id));
    }

    public boolean exist(final Long id) {
        return userRepository.findById(id).isPresent();
    }

    //Анонимная реализация
//        Supplier mySupplier = new Supplier() {
//            @Override
//            public User get() {
//                return new User(1L, "1");
//            }
//        };
//
//        //Лямбда выражения
//        Supplier<User> mySupplier1 = () -> {
//            System.out.println("Hello");
//            return new User(1L, "1");
//        };
//
//        //2 Без тела метода { }
//        Supplier<User> mySupplier2 = () -> new User(1L, "1");
//
//        //3 Method reference
//        Supplier<User> mySupplier3 = User::new;
//
//        Function<User, Long> mapUserToLong = new Function<User, Long>() {
//            @Override
//            public Long apply(User user) {
//                return user.getId();
//            }
//        };
//
//        Function<User, Long> mapUserToLong1 = (asas12e1dasd) -> {
//            return asas12e1dasd.getId();
//        };
//
//        Function<User, Long> mapUserToLong2 = (asas12e1dasd) -> asas12e1dasd.getId();
//        Function<User, Long> mapUserToLong3 = User::getId;

}
