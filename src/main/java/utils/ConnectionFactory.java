package utils;

import exceptions.NoDatabasePropertyException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 1 on 01.02.2016.
 */
public class ConnectionFactory {

    public static Connection newConnection () throws ClassNotFoundException, NoDatabasePropertyException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        String url = DatabaseConnectionPropertiesLoader.getProperty("db.url");
        String user = DatabaseConnectionPropertiesLoader.getProperty("db.name");
        String password = DatabaseConnectionPropertiesLoader.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }

}
