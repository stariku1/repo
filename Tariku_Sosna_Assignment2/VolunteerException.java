/**
 * volunteer exception class
 * 
 * @author tz_as
 *
 */
public class VolunteerException extends RuntimeException {
	/**
	 * constructor with nothing at all
	 */
	public VolunteerException() {
	};

	/**
	 * constructor of volunteer message
	 * 
	 * @param message message
	 */
	VolunteerException(String message) {
		super(message);
	}

}
