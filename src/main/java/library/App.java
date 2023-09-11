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
import library.repository.CommentUserRepository;
import library.repository.UserRepository;
import library.service.BookService;
import library.service.CommentUserService;
import library.service.LibraryService;
import library.service.UserService;

import java.time.LocalDate;

public class App {
    public static void main(final String[] args) {
        final UserRepository userRepository = new UserRepository();
        final BookRepository bookRepository = new BookRepository();

        BookUserRepository bookUserRepository = new BookUserRepository();
        UserService userService = new UserService(userRepository);
        BookService bookService = new BookService(bookRepository);
        CommentUserRepository commentUserRepository = new CommentUserRepository();
        LibraryService libraryService = new LibraryService(bookService, userService, bookUserRepository);
        CommentUserService commentUserService = new CommentUserService("", userService, libraryService, commentUserRepository);

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

        BookUser bookUser = libraryService.bookIssue(user1.getId(), book3.getId());
        System.out.println(bookUser);

//        BookUser bookUser1 = libraryService.bookIssue(user1.getId(), book3.getId());
//        System.out.println(bookUser1);

        BookUser bookUser1 = libraryService.returnBook(book3.getId()); // возвращает
        System.out.println(bookUser1);

        commentUserService.commentUserAdd(1L, 3L, "Read good");
        System.out.println(commentUserRepository);
    }
}
