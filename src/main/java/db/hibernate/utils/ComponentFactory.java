package db.hibernate.utils;

import db.hibernate.habr.repository.CommentRepository;
import db.hibernate.habr.repository.PostRepository;
import db.hibernate.library.repository.BookRepository;
import db.hibernate.library.repository.BookUserRepository;
import db.hibernate.library.repository.ReviewRepository;
import db.hibernate.library.repository.UserRepository;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ComponentFactory {

    public static <T> T createRepository(final Class<T> clazz) {
        if (clazz.equals(PostRepository.class)) {
            return (T) new PostRepository();
        } else if (clazz.equals(CommentRepository.class)) {
            return (T) new CommentRepository();
        } else if (clazz.equals(BookRepository.class)) {
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
