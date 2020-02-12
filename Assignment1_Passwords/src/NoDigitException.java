



public class NoDigitException extends Exception {
/**
 * Constructor with a written message
 */


public NoDigitException()

{
super ("The password must contain at least one digit.");
}

  
/**
 * Constructor with string parameter
 * @param message message
 */

public NoDigitException(String message)

{

super(message);

}

}
