//PasswordChecker.java

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.control.Tooltip;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.VBox;

import javafx.scene.layout.HBox;

import javafx.stage.Stage;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.geometry.Pos;

import javafx.geometry.Insets;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.ArrayList;

import java.util.Scanner;

import javax.swing.JFileChooser;

import javax.swing.JOptionPane;

public class PasswordChecker implements PasswordCheckerInterface {

  

private String password; // Will hold the string that is passed into the isValidPassword method.

private ArrayList<String> illegalPasswords; // Will hold the list of passwords that are found to be invalid from the list that is passed into the validPasswords method.

  

public boolean isValidPassword (String passwordString) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException

{

password = passwordString;

char ch = password.charAt(0);

  

// If the password is less than 8 characters, then throw the lengthException.

if( password.length() < 8)

{

throw new LengthException ("The password must be at least 8 characters long.");

}

  

// If the first character in the password is not a numeric character, then check to see if the rest of the password contains at least one numeric character.

if(!Character.isDigit(ch))

{

// Set the initial value of hasDigit to be false

boolean hasDigit = false;

  

// Loop through the length of the password, and if there is a character that has a digit, then the variable hasDigit will be true.

for (int i = 0; i < password.length(); i++)

{

ch = password.charAt(i);

  

if(Character.isDigit(ch))

{

hasDigit = true;

}

}

  

// If there is no digit, then throw the NoDigitException

if(!hasDigit)

{

throw new NoDigitException ("The password must contain at least one digit.");

}

}

  

// If the first character in the password is not upper case, then check to see if the rest of the password contains at least one upper case letter.

if(!Character.isUpperCase(ch))

{

boolean hasUppercase = !password.equals(password.toLowerCase());

  

//If the password does not have uppercase, then throw the NoUpperAlphaException.

if(!hasUppercase)

{

throw new NoUpperAlphaException ("The password must contain at least one uppercase alphabetic character.");

}

}

  

// If the first character in the password is not lower case, then check to see if the rest of the password contains at least one lower case letter.

if(!Character.isLowerCase(ch))

{

boolean hasLowercase = !password.equals(password.toUpperCase());

  

if(!hasLowercase)

{

throw new NoLowerAlphaException ("The password must contain at least one lowercase alphabetic character.");

}

}

  

// If the first character in the password is either a lower case, upper case, or numeric character, then check to see if the password does not contain more than 2 of the same character in sequence.

if(Character.isLowerCase(ch) || Character.isUpperCase(ch) || Character.isDigit(ch) )

{

for (int i = 0; i < password.length() - 2; i++)

{

if( (password.charAt(i) == password.charAt(i + 1)) && (password.charAt(i) == password.charAt(i+2)) )

{

throw new InvalidSequenceException ("The password cannot contain more than two of the same character in sequence.");

}

}

}

return true;

}

/**

* Will check an ArrayList of passwords and returns an ArrayList with the status of any invalid passwords.

*/

public ArrayList<String> validPasswords(ArrayList<String> passwords)

{

// an ArrayList to hold all the invalid passwords found

illegalPasswords = new ArrayList<String>();

  

String errorMessage = null;

  

for(int i = 0; i < passwords.size(); i++)

{

try

{

isValidPassword(passwords.get(i));

}

  

catch (LengthException e)

{

errorMessage = passwords.get(i) + " The password must be at least 8 characters long.";

illegalPasswords.add(errorMessage);

}

catch (NoDigitException e) {

errorMessage = passwords.get(i) + " The password must contain at least one digit.";

illegalPasswords.add(errorMessage);

}

catch (NoUpperAlphaException e) {

errorMessage = passwords.get(i) + " The password must contain at least one uppercase alphabetic character.";

illegalPasswords.add(errorMessage);

}

catch (NoLowerAlphaException e) {

errorMessage = passwords.get(i) + " The password must contain at least one lowercase alphabetic character.";

illegalPasswords.add(errorMessage);

}

catch (InvalidSequenceException e) {

errorMessage = passwords.get(i) + " The password cannot contain more than two of the same character in sequence.";

illegalPasswords.add(errorMessage);

}

}

  

//Return the ArrayList that contains all the invalid passwords only

return illegalPasswords;

}

}