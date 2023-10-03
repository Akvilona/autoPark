package hibernate;

import hibernate.entity.Book;
import hibernate.entity.BookUser;
import hibernate.entity.User;
import hibernate.repository.BookRepository;
import hibernate.repository.BookUserRepository;
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

        BookRepository bookRepository = ComponentFactory.createRepository(BookRepository.class);
        UserRepository userRepository = ComponentFactory.createRepository(UserRepository.class);
        BookUserRepository bookUserRepository = ComponentFactory.createRepository(BookUserRepository.class);
        bookRepository.save(book);
        userRepository.save(user);
        bookUserRepository.save(bookUser);

        List<Book> bookAll = bookRepository.findAll();
        System.out.println(bookAll);


    }
}
