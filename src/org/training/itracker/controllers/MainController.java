package org.training.itracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.training.itracker.beans.Issue;
import org.training.itracker.constants.Constants;
import org.training.itracker.utilities.BackButton;

@Controller
public class MainController extends AbstractController {
	private static final long serialVersionUID = 1L;

	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sort = request.getParameter("sort");

		List<Issue> allIssues;
		// IssueDAO issueDao = IssueFactory.getClassFromFactory();
		// if (sort != null) {
		// allIssues = issueDao.getAllIssues(sort);
		// } else {
		// allIssues = issueDao.getAllIssues();
		// }
		// session.setAttribute(Constants.ATTRIBUTE_ISSUE_LIST, allIssues);

		BackButton.showSubmitHideBack(session);
		jump(Constants.JUMP_MAIN, request, response);
	}
}