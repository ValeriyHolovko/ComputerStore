package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import constants.Constants;

public class LanguageResourceBundle {

    private static String localization;
    private static Map map;

    public static String LOCALE_PATH = Constants.LOCALE_RESOURCES_PATH + "\\%s_dictionary.properties";

    static {
        Locale currentLocale = Locale.getDefault();
        localization = currentLocale.getLanguage();

        LOCALE_PATH = String.format(LOCALE_PATH, localization);

        try {

            Properties properties = new Properties();
            properties.load(new FileInputStream(LOCALE_PATH));

            map = properties;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String get(String key) {
        return map.get(key).toString();
    }
}
