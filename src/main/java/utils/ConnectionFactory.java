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

        String url = null;
        String user = null;
        String password = null;
        try {
            url = DatabaseConnectionPropertiesLoader.getProperty("db.url");
            user = DatabaseConnectionPropertiesLoader.getProperty("db.name");
            password = DatabaseConnectionPropertiesLoader.getProperty("db.password");
        } catch (NoDatabasePropertyException e) {
            throw new NoDatabasePropertyException("Have no information about database");
        }

        return DriverManager.getConnection(url, user, password);
    }

}
