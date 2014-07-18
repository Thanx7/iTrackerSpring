package org.training.itracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.training.itracker.constants.Constants;
import org.training.itracker.utilities.CryptWithMD5;

public class LoginController extends AbstractController {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger
			.getLogger(LoginController.class);

	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = request.getParameter(Constants.EMAIL);
		String password = request.getParameter(Constants.PASSWORD);

		// UserDAO userDAO = UserFactory.getClassFromFactory();
		// try {
		password = CryptWithMD5.cryptWithMD5(password);
		// User user = userDAO.getUser(email, password);
		// session.setAttribute(Constants.ATTRIBUTE_USER, user);

		jump(Constants.JUMP_MAIN, request, response);
		// } catch (DAOException e) {
		// jump(Constants.JUMP_MAIN, request, response, e.getMessage());
		// }
	}
}