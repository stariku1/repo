/**
 * recipient exception class
 * 
 * @author tz_as
 *
 */
public class RecipientException extends RuntimeException {

	/**
	 * constructor with nothing at all
	 */
	public RecipientException() {
	};

	/**
	 * pre set message by user
	 * 
	 * @param message message
	 */
	RecipientException(String message) {
		super(message);
	}

}
