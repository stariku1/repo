import java.util.ArrayList;
/**
 * 
 * @author tz_as
 *
 */
public class PasswordCheckerUtility {
/**
 * 
 * @param passwordString string to be checked for validity
 * @return true if valid password, set up to return false if an invalid password, but throws an exception instead.
 * @throws InvalidSequenceException thrown if more than 2 of same character.
 * @throws NoDigitException  thrown if no digit
 * @throws NoUpperAlphaException thrown if no uppercase alphabetic
 * @throws NoLowerAlphaException thrown if no lowercase alphabetic
 * @throws LengthException thrown if length is less than 6 characters
 */
	static boolean isValidPassword(String passwordString) throws InvalidSequenceException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, LengthException {
		boolean numeric=false;
		boolean Uppercase=false;
		boolean lowercase=false;
		for (int i=0;i<passwordString.length();i++) {
			char c = passwordString.charAt(i);
			if (Character.isDigit(c)) {
				numeric=true;
			}
			if(Character.isUpperCase(c)) {
				Uppercase=true;
			}
			if(Character.isLowerCase(c)) {
				lowercase=true;
			}
			if(i+2<=passwordString.length()-1 && c == passwordString.charAt(i+1) && c == passwordString.charAt(i+2)) {
				throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
			}
		}
		if (passwordString.length()<6) {
			throw new LengthException("Length of password is less than 6 characters ");
		}
		if (numeric==false) {
			throw new NoDigitException("The password must contain at least one digit.");
		}
		if (Uppercase==false) {
			throw new NoUpperAlphaException("Password doesn’t contain an uppercase alpha character");
		}
		if (lowercase==false) {
			throw new NoLowerAlphaException("Password doesn’t contain a lowercase alpha character ");
		}
		return true;
	}
	
	/**
	 * Return true if length of password is greater than or equal to 6 but less than or equal to 9
	 * @param passwordString string to be checked if weak password
	 * @return true if length of password is greater than or equal to 6 but less than or equal to 9
	 */
	static boolean isWeakPassword(String passwordString) {
		if (passwordString.length()>=10 ) {
			return false;
		}
		return true;
	}
	/**
	 * 
	 * Return true if length of password is greater than or equal to 6 but less than or equal to 9
	 * @param passwords  arraylist of passwords to check for validity
	 * @return true if length of password is greater than or equal to 6 but less than or equal to 9
	 */
	static ArrayList<String> invalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> arr = new ArrayList<String>();
		for (String string: passwords) {
			try {
				isValidPassword(string);
			}
			catch(Exception e) {
				arr.add(string + " " + e.getMessage());
			}
		}
		return arr; 
	}
	/**
	 * 
	 * Returns an arraylist of invalid passwords (weak passwords are not considered invalid)
	 * @param passwords arraylist of passwords to check for validity
	 * @return arraylist of invalid passwords. It will not return weak passwords.
	 */
	static ArrayList<String> validPasswords(ArrayList<String> passwords) {
		ArrayList<String> arr = new ArrayList<String>();
		for (String string: passwords) {
			try {
				isValidPassword(string);
			}
			catch(Exception e) {
				arr.add(string + " " + e.getMessage());
			}
		}
		return arr; 
	}
}

