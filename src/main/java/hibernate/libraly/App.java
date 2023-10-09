package hibernate.libraly;

import hibernate.libraly.entity.Book;
import hibernate.libraly.entity.BookUser;
import hibernate.libraly.entity.Review;
import hibernate.libraly.entity.User;
import hibernate.libraly.repository.BookRepository;
import hibernate.libraly.repository.BookUserRepository;
import hibernate.libraly.repository.ReviewRepository;
import hibernate.libraly.repository.UserRepository;
import hibernate.libraly.utils.ComponentFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
                .book(Book.builder()
                        .name(String.valueOf(new Random().nextInt()))
                        .dateOfIssue(LocalDate.now())
                        .build())
                .user(User.builder()
                        .age(21)
                        .name(String.valueOf(new Random().nextInt()))
                        .build())
                .comment("comment")
                .build();

        BookRepository bookRepository = ComponentFactory.createRepository(BookRepository.class);
        UserRepository userRepository = ComponentFactory.createRepository(UserRepository.class);
        BookUserRepository bookUserRepository = ComponentFactory.createRepository(BookUserRepository.class);
        ReviewRepository reviewRepository = ComponentFactory.createRepository(ReviewRepository.class);

        reviewRepository.save(review);
        //reviewRepository.delete(review);

/*        review.setComment("no comment");
        reviewRepository.save(review);
*/
//        bookRepository.save(book);
//        bookUserRepository.save(bookUser);

        // TODO: не получается сохранить review
//        reviewRepository.save(review);
/*        bookRepository.save(book);
        userRepository.save(user);
        bookUserRepository.save(bookUser);
*/
         // TODO: почему то возвращает только первые две записи
/*        List<User> userAll = userRepository.findAll();
        System.out.println(userAll);
*/
/*        List<BookUser> bookUsers = bookUserRepository.findAll();
        System.out.println(bookUsers);
*/
    }
}
