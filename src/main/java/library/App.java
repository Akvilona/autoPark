package library;

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

        reviewService.delete(7L);
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
