package org.training.itracker.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.itracker.beans.Issue;
import org.training.itracker.beans.Project;
import org.training.itracker.beans.Status;
import org.training.itracker.beans.User;
import org.training.itracker.constants.Constants;
import org.training.itracker.constants.MessageConstants;
import org.training.itracker.service.IssueService;
import org.training.itracker.service.ProjectService;
import org.training.itracker.service.StatusService;
import org.training.itracker.service.UserService;
import org.training.itracker.utilities.BackButton;
import org.training.itracker.utilities.CryptWithMD5;
import org.training.itracker.utilities.DAOException;

@Controller
public class MainController {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(MainController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private StatusService statusService;

	@Autowired
	private IssueService issueService;

	@Autowired
	private ProjectService projectService;

	private final static int ISSUES_ON_PAGE = 10;

	@RequestMapping(value = { "/index", "/", "/main" })
	public String main(HttpSession session,
			@RequestParam(value = "sort", required = false) String sort) {

		List<User> users = userService.getAllUsers();
		session.setAttribute(Constants.ATTRIBUTE_USERS, users);

		List<Status> statuses = statusService.getStatuses();
		session.setAttribute(Constants.ATTRIBUTE_STATUSES, statuses);

		List<Issue> allIssues;
		if (sort != null) {
			allIssues = issueService.getAllIssues(sort);
		} else {
			allIssues = issueService.getAllIssues();
		}

		if (allIssues.size() <= ISSUES_ON_PAGE) {
			session.setAttribute(Constants.ATTRIBUTE_ISSUE_LIST, allIssues);
		} else {
			List<Issue> tmpIssuesList = new ArrayList<Issue>();
			for (int i = allIssues.size() - ISSUES_ON_PAGE; i < allIssues
					.size(); i++) {
				tmpIssuesList.add(allIssues.get(i));
			}
			session.setAttribute(Constants.ATTRIBUTE_ISSUE_LIST, tmpIssuesList);
		}

		BackButton.showSubmitHideBack(session);
		return "main";
	}

	@RequestMapping(value = "/login")
	public String login(HttpSession session,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {

		try {
			password = CryptWithMD5.cryptWithMD5(password);
			User user = userService.getUser(email, password);
			session.setAttribute(Constants.ATTRIBUTE_USER, user);
		} catch (DAOException e) {
			session.setAttribute(MessageConstants.ERROR_MESSAGE, e.getMessage());
		}
		return "main";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.setAttribute(Constants.ATTRIBUTE_USER, null);
		return "redirect:main";
	}

	@RequestMapping(value = "/issueDetails")
	public String main(HttpSession session, ModelMap model,
			@RequestParam(value = "id") Issue issue) {

		model.addAttribute("issue", issue);

		List<Project> projects = projectService.getProjects();
		session.setAttribute(Constants.ATTRIBUTE_PROJECTS, projects);

		BackButton.showBackHideSubmit(session);
		return "issueDetails";
	}
}