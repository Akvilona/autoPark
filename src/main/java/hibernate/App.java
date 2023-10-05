package hibernate;

import hibernate.entity.Book;
import hibernate.entity.BookUser;
import hibernate.entity.Review;
import hibernate.entity.User;
import hibernate.repository.BookRepository;
import hibernate.repository.BookUserRepository;
import hibernate.repository.ReviewRepository;
import hibernate.repository.UserRepository;
import hibernate.utils.ComponentFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(final String[] args) {
        Book book = Book.builder()
                .name(String.valueOf(new Random().nextInt()))
                .dateOfIssue(LocalDate.now())
                .build();

        User user = User.builder()
                .age(21)
                .name(String.valueOf(new Random().nextInt()))
                .build();

        BookUser bookUser = BookUser.builder()
                .user(user)
                .book(book)
                .dateFrom(LocalDateTime.now())
                .dateTo(LocalDateTime.now())
                .build();

        Review review = Review.builder()
                .book(book)
                .user(user)
                .comment("asdfasdfasdf")
                .build();

        BookRepository bookRepository = ComponentFactory.createRepository(BookRepository.class);
        UserRepository userRepository = ComponentFactory.createRepository(UserRepository.class);
        BookUserRepository bookUserRepository = ComponentFactory.createRepository(BookUserRepository.class);
        ReviewRepository reviewRepository = ComponentFactory.createRepository(ReviewRepository.class);
        // TODO: не получается сохранить review
        reviewRepository.save(review);
/*        bookRepository.save(book);
        userRepository.save(user);
        bookUserRepository.save(bookUser);
*/
         // TODO: почему то возвращает только первые две записи
/*        List<User> userAll = userRepository.findAll();
        System.out.println(userAll);

        List<BookUser> bookUsers = bookUserRepository.findAll();
        System.out.println(bookUsers);
*/
    }
}
