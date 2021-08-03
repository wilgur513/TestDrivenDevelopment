package highlight;

public class CurrentIsNotLastTargetException extends IllegalStateException {
    public CurrentIsNotLastTargetException(String message) {
        super(message);
    }

    public CurrentIsNotLastTargetException(Throwable cause) {
        super(cause);
    }
}
