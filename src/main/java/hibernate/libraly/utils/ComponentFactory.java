package hibernate.libraly.utils;

import hibernate.libraly.repository.BookRepository;
import hibernate.libraly.repository.BookUserRepository;
import hibernate.libraly.repository.ReviewRepository;
import hibernate.libraly.repository.UserRepository;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ComponentFactory {

    public static <T> T createRepository(final Class<T> clazz) {
        if (clazz.equals(BookRepository.class)) {
            return (T) new BookRepository();

        } else if (clazz.equals(UserRepository.class)) {
            return (T) new UserRepository();

        } else if (clazz.equals(BookUserRepository.class)) {
            return (T) new BookUserRepository();

        } else if (clazz.equals(ReviewRepository.class)) {
            return (T) new ReviewRepository();
        }

        throw new IllegalArgumentException("Unknown repository type: " + clazz.getName());
    }
}
