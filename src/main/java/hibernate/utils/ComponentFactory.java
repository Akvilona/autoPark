package hibernate.utils;

import hibernate.repository.BookRepository;
import hibernate.repository.UserRepository;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ComponentFactory {

    @SuppressWarnings("unchecked")
    public static <T> T createRepository(Class<T> clazz) {
        if (clazz.equals(BookRepository.class)) {
            return (T) new BookRepository();
        } else if (clazz.equals(UserRepository.class)) {
            return (T) new UserRepository();
        }
        throw new IllegalArgumentException("Unknown repository type: " + clazz.getName());

    }
}
