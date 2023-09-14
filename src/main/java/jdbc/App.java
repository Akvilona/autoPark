/**
 * Создал Андрей Антонов 14.09.2023 12:00
 **/
package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(final String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

            initDataBase();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void initDataBase() throws SQLException {
        try (Connection connection = DbUtils.getConnection();
            Statement statement = connection.createStatement()) {
            String createCommentsTable = """
                    create table if not exists comment (
                        id serial primary key,
                        comment varchar(255) default null
                    );
                """;
            statement.execute(createCommentsTable);

            String createUsersTable = """
                    create table if not exists users (
                        id serial primary key,
                        username varchar(50) default null,
                        email varchar(255) UNIQUE NOT NULL,
                        created_on  TIMESTAMP NOT NULL
                    );
                """;
            statement.execute(createUsersTable);
            connection.commit();

        }
    }
}
