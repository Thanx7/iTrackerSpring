package org.training.itracker.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.training.itracker.beans.User;
import org.training.itracker.constants.MessageConstants;

public final class Validation {
	// registration errors
	public static final String ERROR_PASSWORDS_DO_NOT_MATCH = "The passwords you entered do not match.";
	public static final String ERROR_EMAIL_VALIDATE = "The e-mail address you entered is invalid.";
	// ERROR_REGISTERED = "This name is already taken.";

	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static void login(User user, String password) throws DAOException {
		if (user == null)
			throw new DAOException(MessageConstants.ERROR_NO_SUCH_USER);
		if (!password.equals(user.getPassword()))
			throw new DAOException(MessageConstants.ERROR_PASSWORD);
	}

	public static void registration(String email, String password,
			String confirmPassword) throws DAOException {

		if (!confirmPassword.equals(password))
			throw new DAOException(ERROR_PASSWORDS_DO_NOT_MATCH);

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.find())
			throw new DAOException(ERROR_EMAIL_VALIDATE);
	}
}