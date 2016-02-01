package exceptions;

/**
 * Created by 1 on 01.02.2016.
 */
public class NoDatabasePropertyException extends Exception {

    public NoDatabasePropertyException() {
    }

    public NoDatabasePropertyException(String message) {
        super(message);
    }
}
