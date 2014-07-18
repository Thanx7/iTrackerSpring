package org.training.itracker.utilities;

import javax.servlet.http.HttpSession;

public class BackButton {
	private static final String SUBMIT_BUTTON = "sb";
	private static final String BACK_BUTTON = "bb";
	private static final String DISABLED = "disable";

	public static void showBackHideSubmit(HttpSession session) {
		session.removeAttribute(BACK_BUTTON);
		session.setAttribute(SUBMIT_BUTTON, DISABLED);
	}

	public static void showSubmitHideBack(HttpSession session) {
		session.removeAttribute(SUBMIT_BUTTON);
		session.setAttribute(BACK_BUTTON, DISABLED);
	}
}