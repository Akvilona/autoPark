package library;

import library.entity.Book;
import library.entity.BookUser;
import library.entity.User;
import library.repository.db.BookDBRepository;
import library.repository.db.BookUserDBRepository;
import library.repository.db.ReviewDBRepository;
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
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class App {
    @SneakyThrows
    public static void main(final String[] args) {
        Class.forName("org.postgresql.Driver");

        UserDBRepository userDBRepository = new UserDBRepository();
        BookDBRepository bookDBRepository = new BookDBRepository();
        BookUserDBRepository bookUserDBRepository = new BookUserDBRepository();
        ReviewDBRepository reviewDBRepository = new ReviewDBRepository();

        UserService userService = new UserService(userDBRepository);
        BookService bookService = new BookService(bookDBRepository);
        ReviewService reviewService = new ReviewService(reviewDBRepository);

        BookUserService bookUserService = new BookUserService(bookService, userService, bookUserDBRepository);
        //======//======//======//======//======//======//======//======//======

        initDataBase();

        Instant start = Instant.now();

        User userSaved = userService.save(new User("1"));
        Book bookSaved = bookService.save(new Book("1", LocalDate.now()));

        BookUser bookUser = bookUserService.bookIssue(userSaved.getId(), bookSaved.getId());
        BookUser bookUser1 = bookUserService.returnBook(bookUser.getBookId());
        System.out.println(bookUser1);

        Instant end = Instant.now();
        //PT0.324122S с получения
        //PT0.3241853S у меня
        System.out.println(Duration.between(start, end));

    }

    private static void initDataBase() {
        Connection connection = DbUtils.getConnection();
        try (Statement statement = connection.createStatement()) {

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
