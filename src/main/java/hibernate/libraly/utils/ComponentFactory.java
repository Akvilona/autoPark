package hibernate.libraly.utils;
import library.repository.list.BookRepository;
import library.repository.list.BookUserRepository;
import library.repository.list.ReviewRepository;
import library.repository.list.UserRepository;
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
