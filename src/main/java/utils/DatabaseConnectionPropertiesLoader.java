package utils;

import constants.Constants;
import exceptions.NoDatabasePropertyException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by 1 on 01.02.2016.
 */
public class DatabaseConnectionPropertiesLoader {

    private static Map DbPropertiesMap;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(Constants.DB_PROPERTIES_LOCATION));
            DbPropertiesMap = properties;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String property) throws NoDatabasePropertyException {

        if (DbPropertiesMap.containsKey(property)) {
            return DbPropertiesMap.get(property).toString();
        }
        throw new NoDatabasePropertyException();
    }
}
