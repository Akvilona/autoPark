package library;

//TODO: Библиотека
//TODO: Была возможность добавления, удаления книги из библиотеки
//TODO: Была возможность взять книгу для зарегистрированного пользователя
//TODO: Возможность регистрации пользователя

import library.model.Book;
import library.model.User;
import library.repository.BookRepository;
import library.repository.UserRepository;
import library.service.BookService;
import library.service.LibraryService;
import library.service.UserService;

import java.sql.Date;
import java.time.LocalDate;

public class App {
    public static void main(final String[] args) {
        final UserRepository userRepository = new UserRepository();
        final BookRepository bookRepository = new BookRepository();

        UserService userService = new UserService(userRepository);
        BookService bookService = new BookService(bookRepository);
        LibraryService libraryService = new LibraryService(bookService, userService);

        User user1 = new User(1L, "Name1");
        User user2 = new User(2L, "Name2");

        userService.save(user1);
        userService.save(user2);

        Book book1 = new Book(1L,"Lev Tolstoy", LocalDate.of(1991,1,1));
        Book book2 = new Book(2L,"Lev Tolstoy", LocalDate.of(1992,2,2));
        Book book3 = new Book(3L,"Lev Tolstoy", LocalDate.of(1993,3,3));

        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);

        System.out.println(bookService.findAll());
        libraryService.bookIssue(user1.getId(), book3.getId());
        System.out.println(bookService.findAll());
        libraryService.bookDelete(user1.getId(), book3.getId());
        System.out.println(bookService.findAll());
    }
}
