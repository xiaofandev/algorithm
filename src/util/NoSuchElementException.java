package util;

public class NoSuchElementException extends RuntimeException {

	private static final long serialVersionUID = 569454332137957559L;

	public NoSuchElementException() {
        super();
    }
	
	public NoSuchElementException(String message) {
        super(message);
    }
	
	public NoSuchElementException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public NoSuchElementException(Throwable cause) {
        super(cause);
    }
}
