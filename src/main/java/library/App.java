package library;

//TODO: Библиотека
//TODO: Была возможность добавления, удаления книги из библиотеки
//TODO: Была возможность взять книгу для зарегистрированного пользователя
//TODO: Возможность регистрации пользователя

import library.model.Book;
import library.model.BookUser;
import library.model.User;
import library.repository.BookRepository;
import library.repository.BookUserRepository;
import library.repository.ReviewRepository;
import library.repository.UserRepository;
import library.service.BookService;
import library.service.ReviewService;
import library.service.BookUserService;
import library.service.UserService;

import java.time.LocalDate;

public class App {
    public static void main(final String[] args) {
        UserRepository userRepository = new UserRepository();
        BookRepository bookRepository = new BookRepository();

        BookUserRepository bookUserRepository = new BookUserRepository();
        UserService userService = new UserService(userRepository);
        BookService bookService = new BookService(bookRepository);
        ReviewRepository reviewRepository = new ReviewRepository();
        BookUserService bookUserService = new BookUserService(bookService, userService, bookUserRepository);
        ReviewService reviewService = new ReviewService(userService, bookUserService, reviewRepository);

        User user1 = new User(1L, "Name1");
        User user2 = new User(2L, "Name2");

        userService.save(user1);
        userService.save(user2);

        Book book1 = new Book(1L, "Lev Tolstoy", LocalDate.of(1991, 1, 1));
        Book book2 = new Book(2L, "Lev Tolstoy", LocalDate.of(1992, 2, 2));
        Book book3 = new Book(3L, "Lev Tolstoy", LocalDate.of(1993, 3, 3));
        System.out.println(bookService.findAll());

        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);

        BookUser bookUser = bookUserService.bookIssue(user1.getId(), book3.getId());
        System.out.println(bookUser);

//        BookUser bookUser1 = libraryService.bookIssue(user1.getId(), book3.getId());
//        System.out.println(bookUser1);

        BookUser bookUser1 = bookUserService.returnBook(book3.getId()); // возвращает
        System.out.println(bookUser1);

        reviewService.addReview(1L, 3L, "Read good");
        System.out.println(reviewRepository.findAll());
    }
}
