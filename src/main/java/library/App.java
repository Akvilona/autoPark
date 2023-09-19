package library;

//TODO: Библиотека
//TODO: Была возможность добавления, удаления книги из библиотеки
//TODO: Была возможность взять книгу для зарегистрированного пользователя
//TODO: Возможность регистрации пользователя

import library.model.Book;
import library.model.BookUser;
import library.repository.BookUserRepository;
import library.repository.ReviewRepository;
import library.repository.db.BookDBRepository;
import library.repository.db.BookUserDBRepository;
import library.repository.db.UserDBRepository;
import library.service.BookService;
import library.service.BookUserService;
import library.service.ReviewService;
import library.service.UserService;
import library.utils.DbUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class App {
    @SneakyThrows
    public static void main(final String[] args) {
        Class.forName("org.postgresql.Driver");

        UserDBRepository userDBRepository = new UserDBRepository();
        BookDBRepository bookDBRepository = new BookDBRepository();
        BookUserDBRepository bookUserDBRepository = new BookUserDBRepository();

        UserService userService = new UserService(userDBRepository);
        BookService bookService = new BookService(bookDBRepository);

        ReviewRepository reviewRepository = new ReviewRepository();
        BookUserService bookUserService = new BookUserService(bookService, userService, bookUserDBRepository);
        ReviewService reviewService = new ReviewService(userService, bookUserService, reviewRepository);
        //======//======//======//======//======//======//======//======//======


        initDataBase();

//        userService.save(new User("postgres1"));
        LocalDate date = LocalDate.now();
        bookService.save(new Book("book_name123", date));
//        List<Book> book = bookService.findAll();
//        Book book = bookService.findById(-3L);
//        System.out.println(book);

        BookUser bookUser = bookUserService.bookIssue(1L, 1L);
        System.out.println(bookUser);

//        User user = userService.findById(4L);
//        System.out.println(user);
//        userService.delete(2L);
//      List<User> allUsers = userService.findAll();
//        System.out.println(allUsers);

    }

    private static void initDataBase() {
        try (Connection connection = DbUtils.getConnection();
             Statement statement = connection.createStatement()) {

            String createCommentsTable = """
                    create table if not exists book
                         (
                             id             serial primary key,
                             name           varchar(255) default null,
                             dateOfIssue    timestamp default null
                         );
                    """;
            statement.execute(createCommentsTable);

            String createUsersTable = """
                    create table if not exists users
                         (
                             id             serial primary key,
                             name           varchar(50)
                         );
                    """;
            statement.execute(createUsersTable);

            String createReviewTable = """
                    create table if not exists review
                         (
                             id             serial primary key,
                             book_id        bigint not null,
                             user_id        bigint not null,
                             comment        varchar(255)
                         );
                    """;
            statement.execute(createReviewTable);

            //TODO: create unique index (book_id, user_id)
            String createBookUserTable = """
                    create table if not exists bookUser
                         (
                             id             serial primary key,
                             book_id        bigint not null,
                             user_id        bigint not null,
                             from_date_time timestamp not null,
                             to_date_time   timestamp not null,
                             return_date_time timestamp
                         );
                    """;
            statement.execute(createBookUserTable);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
