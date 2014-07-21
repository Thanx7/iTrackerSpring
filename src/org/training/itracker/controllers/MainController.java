package org.training.itracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.itracker.beans.Issue;
import org.training.itracker.constants.Constants;
import org.training.itracker.dao.IssueDAO;
import org.training.itracker.utilities.ApplicationContextProvider;
import org.training.itracker.utilities.BackButton;

@Controller
public class MainController extends AbstractController {
	private static final long serialVersionUID = 1L;

	@RequestMapping("/main.jsp")
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sort = request.getParameter("sort");

		ApplicationContext ctx = ApplicationContextProvider
				.getApplicationContext();

		List<Issue> allIssues;
		IssueDAO issueDao = ctx.getBean(IssueDAO.class);
		if (sort != null) {
			allIssues = issueDao.getAllIssues(sort);
		} else {
			allIssues = issueDao.getAllIssues();
		}
		session.setAttribute(Constants.ATTRIBUTE_ISSUE_LIST, allIssues);

		BackButton.showSubmitHideBack(session);
	}
}