package org.training.itracker.constants;

public final class MessageConstants {
	// login errors
	public static final String ERROR_PASSWORD = "Password is incorrect.";
	public static final String ERROR_NO_SUCH_USER = "No such user found!";
	// registration errors
	public static final String ERROR_PASSWORDS_DO_NOT_MATCH = "The passwords you entered do not match.";
	public static final String ERROR_EMAIL_VALIDATE = "The e-mail address you entered is invalid.";
	public static final String ERROR_REGISTERED = "This name is already taken.";

	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	// add issue errors
	public static final String ERROR_ASSIGNEE_WRONG_STATUS = "Assignee wrong status!";
	public static final String ERROR_MESSAGE = "errorMessage";
	public static final String ISSUE_ADDED = "Issue has been successfully added.";
	public static final String ISSUE_UPDATED = "Issue has been successfully updated.";
}