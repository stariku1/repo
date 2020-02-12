



public class LengthException extends Exception

{

/**
 * *  Constructor with a written message
 */


public LengthException()

{
super ("Length of password is less than 6 characters ");
}

  /**
  * Constructor with string parameter
 * @param sentence sentence
 */



public LengthException(String sentence)

{

super(sentence);

}

}