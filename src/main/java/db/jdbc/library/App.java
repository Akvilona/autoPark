package db.jdbc.library;

import db.jdbc.library.repository.db.ReviewDbRepository;
import db.jdbc.library.service.ReviewService;
import db.jdbc.library.utils.DbUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    @SneakyThrows
    public static void main(final String[] args) {
        Class.forName("org.postgresql.Driver");

        ReviewDbRepository dbRepositoryMy = new ReviewDbRepository();

        ReviewService reviewService = new ReviewService(dbRepositoryMy);

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
