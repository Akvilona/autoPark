/**
 * Создал Андрей Антонов 14.09.2023 12:53
 **/
package jdbc;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DbUtils  {
    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String pass = "postgres";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
