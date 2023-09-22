package library.utils;

import http.com.utils.PropertiesReaderUtils;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DbUtils {

    Connection connectionOld = null;

    public static Connection getConnection() {

//      if (connectionOld == null) {

            try {
                final String url = PropertiesReaderUtils.getProperty("url");
                final String user = PropertiesReaderUtils.getProperty("user");
                final String pass = PropertiesReaderUtils.getProperty("pass");

                //TODO: Переделать получение connection, вместо получени коннекта каждый раз, создать его один раз и
                //использовать
                connectionOld = DriverManager.getConnection(url, user, pass);
                connectionOld.setAutoCommit(false);
//                return connection;
                return connectionOld;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
//      } else {
//            return connectionOld;
//        }
    }
}
