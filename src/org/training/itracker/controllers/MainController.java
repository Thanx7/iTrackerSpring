package org.training.itracker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.itracker.beans.Issue;
import org.training.itracker.beans.Status;
import org.training.itracker.beans.User;
import org.training.itracker.constants.Constants;
import org.training.itracker.service.IssueService;
import org.training.itracker.service.StatusService;
import org.training.itracker.service.UserService;
import org.training.itracker.utilities.BackButton;
import org.training.itracker.utilities.DAOException;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private StatusService statusService;

	@Autowired
	private IssueService issueService;

	@RequestMapping({ "/index", "/" })
	public String mainPage(ModelMap model, HttpSession session)
			throws DAOException {
		// String sort = request.getParameter("sort");

		List<User> users = userService.getAllUsers();
		session.setAttribute(Constants.ATTRIBUTE_USERS, users);
		model.put(Constants.ATTRIBUTE_USERS, users);

		for (User u : users) {
			System.out.println(u);
		}

		List<Status> statuses = statusService.getStatuses();
		session.setAttribute(Constants.ATTRIBUTE_STATUSES, statuses);
		model.put(Constants.ATTRIBUTE_STATUSES, statuses);

		List<Issue> allIssues = issueService.getAllIssues();
		// IssueDAO issueDao = ctx.getBean(IssueDAO.class);
		// if (sort != null) {
		// allIssues = issueDao.getAllIssues(sort);
		// } else {
		// allIssues = issueDao.getAllIssues();
		// }
		session.setAttribute(Constants.ATTRIBUTE_ISSUE_LIST, allIssues);
		model.put(Constants.ATTRIBUTE_ISSUE_LIST, allIssues);

		BackButton.showSubmitHideBack(session);
		return "main";
	}

	// private List<Issue> getIssuesListDefault() {
	// List<Issue> issuesList = issueService.getAllIssues();
	// if (issuesList.size() <= ISSUE_NUMBER) {
	// return issuesList;
	// } else {
	// List<Issue> issuesListDefault = new ArrayList<Issue>();
	// for (int i = issuesList.size() - ISSUE_NUMBER; i < issuesList
	// .size(); i++) {
	// issuesListDefault.add(issuesList.get(i));
	// }
	// return issuesListDefault;
	// }
	// }
}