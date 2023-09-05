package library;

//TODO: Библиотека
//TODO: Была возможность добавления, удаления книги из библиотеки
//TODO: Была возможность взять книгу для зарегистрированного пользователя
//TODO: Возможность регистрации пользователя

import library.model.Book;
import library.model.User;
import library.model.UserBook;
import library.repository.BookRepository;
import library.repository.UserRepository;
import library.service.BookService;
import library.service.UserBookService;
import library.service.UserService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class App {
    public static void main(final String[] args) {
        final UserRepository userRepository = new UserRepository();
        final BookRepository bookRepository = new BookRepository();
        final UserBookService userBookService = new UserBookService(userRepository);

        User user1 = new User(1, "Name1");
        User user2 = new User(2, "Name2");

        Book book1 = new Book(1, "Book1", Date.from(Instant.from(LocalDate.parse("1991/01/01/", DateTimeFormatter.ISO_LOCAL_DATE))));
        Book book2 = new Book(2, "Book2", Date.from(Instant.from(LocalDate.parse("1992/01/01/", DateTimeFormatter.ISO_LOCAL_DATE))));
        Book book3 = new Book(3, "Book3", Date.from(Instant.from(LocalDate.parse("1993/01/01/", DateTimeFormatter.ISO_LOCAL_DATE))));
        Book book4 = new Book(4, "Book4", Date.from(Instant.from(LocalDate.parse("1994/01/01/", DateTimeFormatter.ISO_LOCAL_DATE))));

        UserBook userBook1 = new UserBook(1, 1);
        UserBook userBook2 = new UserBook(2, 2);

        UserService userService = new UserService(userRepository);
        userService.addUser(user1);
        userService.addUser(user2);

        BookService bookService = new BookService(bookRepository);
        bookService.bookAdd(book1);
        bookService.bookAdd(book2);
        bookService.bookAdd(book3);
        bookService.bookAdd(book4);

        System.out.println(userService.getUserByName("Name2"));

        userBookService.addUserBook(userBook1);
        userBookService.addUserBook(userBook2);

    }
}
