

public class NoLowerAlphaException extends Exception {



public NoLowerAlphaException()
/**
 * Constructor with a written message
 */
{
super ("Password doesn’t contain a lowercase alpha character ");
}

  
/**
 * Constructor with string parameter
 * @param sentence sentence
 */


public NoLowerAlphaException(String sentence)

{

super(sentence);

}

}

