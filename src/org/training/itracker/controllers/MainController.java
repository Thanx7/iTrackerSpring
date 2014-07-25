package org.training.itracker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = { "/", "/main" })
	public String entry(HttpSession session) {

		List<User> users = userService.getAllUsers();
		session.setAttribute(Constants.ATTRIBUTE_USERS, users);

		List<Status> statuses = statusService.getStatuses();
		session.setAttribute(Constants.ATTRIBUTE_STATUSES, statuses);

		Integer i;
		try {
			i = Integer.parseInt((String) session.getAttribute("page"));
		} catch (NumberFormatException e) {
			i = 0;
		}

		List<Issue> issues = issueService.getIssues(i,
				(String) session.getAttribute("sort"));
		session.setAttribute(Constants.ATTRIBUTE_ISSUE_LIST, issues);

		Integer issuesCount = issueService.getIssues();
		int pagesCount = (int) Math.ceil((issuesCount - 1)
				/ Constants.ISSUES_ON_PAGE);
		session.setAttribute("pagesCount", pagesCount);

		BackButton.showSubmitHideBack(session);
		return "main";
	}

	@RequestMapping(value = "/main/{sort}")
	public String sort(HttpSession session, @PathVariable("sort") String sort) {
		session.setAttribute("sort", sort);
		return "redirect:/main";
	}

	@RequestMapping(value = "/**/page/{page}")
	public String page(HttpSession session, @PathVariable("page") String page) {
		session.setAttribute("page", page);
		return "redirect:/main";
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
		return "redirect:/main";
	}

	@RequestMapping(value = "/**/logout")
	public String logout(HttpSession session) {
		session.setAttribute(Constants.ATTRIBUTE_USER, null);
		return "redirect:/main";
	}

	@RequestMapping(value = "/issueDetails/{issueId}")
	public String main(HttpSession session, ModelMap model,
			@PathVariable("issueId") Issue issue) {

		model.addAttribute("issue", issue);

		List<Project> projects = projectService.getProjects();
		session.setAttribute(Constants.ATTRIBUTE_PROJECTS, projects);

		BackButton.showBackHideSubmit(session);
		return "issueDetails";
	}
}