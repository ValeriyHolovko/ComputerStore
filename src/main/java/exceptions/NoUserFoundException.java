package exceptions;

/**
 * Created by Valeriy Holovko on 13.04.2016.
 */
public class NoUserFoundException extends Exception {

    public NoUserFoundException() {
    }

    public NoUserFoundException(String message) {
        super(message);
    }
}
