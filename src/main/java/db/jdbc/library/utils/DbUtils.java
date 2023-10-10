package db.jdbc.library.utils;

import http.com.utils.PropertiesReaderUtils;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
@Getter
public class DbUtils {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                final String url = PropertiesReaderUtils.getProperty("url");
                final String user = PropertiesReaderUtils.getProperty("user");
                final String pass = PropertiesReaderUtils.getProperty("pass");

                //использовать
                connection = DriverManager.getConnection(url, user, pass);
                connection.setAutoCommit(false);

                return connection;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return connection;
        }
    }
}
