package library;

//TODO: Библиотека
//TODO: Была возможность добавления, удаления книги из библиотеки
//TODO: Была возможность взять книгу для зарегистрированного пользователя
//TODO: Возможность регистрации пользователя

import library.model.User;
import library.repository.BookRepository;
import library.repository.BookUserRepository;
import library.repository.ReviewRepository;
import library.repository.UserDBRepository;
import library.service.BookService;
import library.service.BookUserService;
import library.service.ReviewService;
import library.service.UserService;
import library.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(final String[] args) {
        UserDBRepository userDBRepository = new UserDBRepository();
        BookRepository bookRepository = new BookRepository();

        BookUserRepository bookUserRepository = new BookUserRepository();
        UserService userService = new UserService(userDBRepository);
        BookService bookService = new BookService(bookRepository);
        ReviewRepository reviewRepository = new ReviewRepository();
        BookUserService bookUserService = new BookUserService(bookService, userService, bookUserRepository);
        ReviewService reviewService = new ReviewService(userService, bookUserService, reviewRepository);
        //======//======//======//======//======//======//======//======//======

        userService.save(new User("postgres"));

        initDataBase();

    }

    private static void initDataBase() {
        try (Connection connection = DbUtils.getConnection();
             Statement statement = connection.createStatement()) {

            String createCommentsTable = """
                    create table if not exists book
                         (
                             id      serial primary key,
                             name varchar(255) default null,
                             dateOfIssue timestamp default null
                         );
                    """;
            statement.execute(createCommentsTable);

            String createUsersTable = """
                    create table if not exists users
                         (
                             id      serial primary key,
                             name varchar(50)
                         );
                    """;
            statement.execute(createUsersTable);

            String createReviewTable = """
                    create table if not exists review
                         (
                             id      serial primary key,
                             book_id      bigint not null,
                             user_id bigint not null,
                             comment varchar(255)
                         );
                    """;
            statement.execute(createReviewTable);

            String createBookUserTable = """
                    create table if not exists bookUser
                         (
                             id      serial primary key,
                             book_id      bigint not null,
                             user_id bigint not null,
                             from_date_time timestamp not null,
                             to_date_time timestamp not null,
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
