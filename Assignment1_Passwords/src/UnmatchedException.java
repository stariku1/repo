

public class UnmatchedException extends Exception {

/**
 *  Constructor with a written message
 */
public UnmatchedException() {
	super("The passwords do not match");


}
/**
 * Constructor with string parameter
 * @param sentence sentence
 */

public UnmatchedException(String sentence)

{

super(sentence);

}

}