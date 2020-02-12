



public class InvalidSequenceException extends Exception {
/**
 *  Constructor with a written message
 */
  



public InvalidSequenceException()

{
super("The password cannot contain more than two of the same character in sequence");
}

  /**
   * Constructor with string parameter
 * @param sentence sentence
 */



public InvalidSequenceException(String sentence)

{

super(sentence);

}

}