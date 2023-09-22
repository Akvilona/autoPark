package library.utils;

import http.com.utils.PropertiesReaderUtils;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DbUtils {
    public static Connection getConnection() {

        try {
            String url = PropertiesReaderUtils.getProperty("url");
            String user = PropertiesReaderUtils.getProperty("user");
            String pass = PropertiesReaderUtils.getProperty("pass");

            //TODO: Переделать получение connection, вместо получени коннекта каждый раз, создать его один раз и
            //использовать
            Connection connection = DriverManager.getConnection(url, user, pass);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
