package util;

public class CapacityNotEnoughException extends RuntimeException {

	private static final long serialVersionUID = 1737630176639621300L;

	public CapacityNotEnoughException() {
        super();
    }
	
	public CapacityNotEnoughException(String message) {
        super(message);
    }
	
}
