package hibernate.utils;

import hibernate.repository.BookRepository;
import hibernate.repository.BookUserRepository;
import hibernate.repository.ReviewRepository;
import hibernate.repository.UserRepository;
import library.entity.Review;
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

        } else if (clazz.equals(Review.class)) {
            return (T) new ReviewRepository();
        }

        throw new IllegalArgumentException("Unknown repository type: " + clazz.getName());
    }
}
