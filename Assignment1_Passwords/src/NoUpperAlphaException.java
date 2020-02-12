


public class NoUpperAlphaException extends Exception {

/**
 *  Constructor with a written message
 */

public NoUpperAlphaException()

{
super ("Password doesn’t contain an uppercase alpha character");
}

  
/**
  * Constructor with string parameter
 * @param sentence sentence
 */


public NoUpperAlphaException(String sentence)

{

super(sentence);

}

}

