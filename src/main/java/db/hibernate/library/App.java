package db.hibernate.library;

import db.hibernate.library.entity.Book;
import db.hibernate.library.entity.Review;
import db.hibernate.library.entity.User;
import db.hibernate.library.repository.ReviewRepository;
import net.datafaker.Faker;

import java.util.Random;

public class App {
    public static void main(final String[] args) {
        Faker faker = new Faker();
        ReviewRepository reviewRepository = new ReviewRepository();

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
    }
}
