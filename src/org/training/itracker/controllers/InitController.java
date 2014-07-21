package org.training.itracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.itracker.constants.Constants;

@Controller
public class InitController extends AbstractController {

	@RequestMapping(value = "/MainController")
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute(Constants.ATTRIBUTE_USER);

		// UserDAO userDAO = UserFactory.getClassFromFactory();
		// List<User> users = userDAO.getAllUsers();
		// session.setAttribute(Constants.ATTRIBUTE_USERS, users);
		//
		// StatusDAO statusDAO = StatusFactory.getClassFromFactory();
		// List<Status> statuses = statusDAO.getStatuses();
		// session.setAttribute(Constants.ATTRIBUTE_STATUSES, statuses);
	}
}