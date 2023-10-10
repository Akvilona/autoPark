package db.hibernate.library;

import db.hibernate.library.entity.Book;
import db.hibernate.library.entity.Review;
import db.hibernate.library.entity.User;
import db.hibernate.library.repository.BookRepository;
import db.hibernate.library.repository.BookUserRepository;
import db.hibernate.library.repository.ReviewRepository;
import db.hibernate.library.repository.UserRepository;
import db.hibernate.utils.ComponentFactory;
import net.datafaker.Faker;

import java.util.Random;

public class App {
    public static void main(final String[] args) {
        Faker faker = new Faker();

        BookRepository bookRepository = ComponentFactory.createRepository(BookRepository.class);
        UserRepository userRepository = ComponentFactory.createRepository(UserRepository.class);
        BookUserRepository bookUserRepository = ComponentFactory.createRepository(BookUserRepository.class);
        ReviewRepository reviewRepository = ComponentFactory.createRepository(ReviewRepository.class);

        Review review = Review.builder()
                .book(Book.builder()
                        .name(faker.book().title())
                        .dateOfIssue(faker.date().birthday().toLocalDateTime().toLocalDate())
                        .build())
                .user(User.builder()
                        .age(new Random().nextInt(100))
                        .name(faker.name().fullName())
                        .build())
                .comment(faker.beer().name())
                .build();

        reviewRepository.save(review);

//        review.setComment("RENAME");
        reviewRepository.save(review);

    }
}
