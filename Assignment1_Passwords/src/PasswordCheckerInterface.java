//PasswordCheckerInterface.java

import java.util.ArrayList;

public interface PasswordCheckerInterface {

/**

*Declaration of isValidPassword method

*it will check the validity of the password ,

*and returns true if the password is valid, otherwise throws an exception.

*/

public boolean isValidPassword (String passwordString) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException;

  

  

/**

* Declaration of validPasswords method

* it will check an ArrayList of passwords and

* it returns an ArrayList with the status of any invalid passwords exists.

*/

public ArrayList<String> validPasswords (ArrayList<String> passwords);

}