/**class for validation for the business requirements
 * */
package com.coding.util;

import org.springframework.stereotype.Component;

@Component
public class Utils {
/**validation method for password (Should be between 8 to 10 characters)
 * */
	public boolean validatePassword(String password) {

		if (password.length() >= 8 && password.length() <= 10) {
			return true;
		}
		return false;
	}

	
	
	/**validation method for email (in well format)
	 * */
	public boolean validateEmail(String email) {

		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

}
