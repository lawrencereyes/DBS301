
@SuppressWarnings("serial")
public class RentPeriodException extends Exception{
	public RentPeriodException () {}

    public RentPeriodException (String message) {
        super (message);
    }

    public RentPeriodException (Throwable cause) {
        super (cause);
    }

    public RentPeriodException (String message, Throwable cause) {
        super (message, cause);
    }
}
