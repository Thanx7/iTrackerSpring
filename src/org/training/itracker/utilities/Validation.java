package org.training.itracker.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.training.itracker.beans.User;
import org.training.itracker.constants.MessageConstants;

public final class Validation {

	public static void login(User user, String password) throws DAOException {
		if (user == null)
			throw new DAOException(MessageConstants.ERROR_NO_SUCH_USER);
		if (!password.equals(user.getPassword()))
			throw new DAOException(MessageConstants.ERROR_PASSWORD);
	}

	public static void registration(String email, String password,
			String confirmPassword) throws DAOException {

		if (!confirmPassword.equals(password))
			throw new DAOException(
					MessageConstants.ERROR_PASSWORDS_DO_NOT_MATCH);

		Pattern pattern = Pattern.compile(MessageConstants.EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.find())
			throw new DAOException(MessageConstants.ERROR_EMAIL_VALIDATE);
	}
}