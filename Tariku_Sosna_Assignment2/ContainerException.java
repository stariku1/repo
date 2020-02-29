/**
 * container exception class
 * 
 * @author tz_as
 *
 */
public class ContainerException extends RuntimeException {

	/**
	 * constructor with nothing at all
	 */
	public ContainerException() {
	};

	/**
	 * constructor with pre-set message
	 * 
	 * @param message pre-set
	 */
	ContainerException(String message) {
		super(message);
	}

}