
@SuppressWarnings("serial")
public class DateFormatException extends Exception{
	public DateFormatException () {}

    public DateFormatException (String message) {
        super (message);
    }

    public DateFormatException (Throwable cause) {
        super (cause);
    }

    public DateFormatException (String message, Throwable cause) {
        super (message, cause);
    }
}
