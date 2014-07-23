package org.training.itracker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.itracker.beans.Comment;
import org.training.itracker.beans.Issue;
import org.training.itracker.beans.Project;
import org.training.itracker.beans.Resolution;
import org.training.itracker.beans.User;
import org.training.itracker.constants.Constants;
import org.training.itracker.constants.MessageConstants;
import org.training.itracker.service.BuildService;
import org.training.itracker.service.CommentService;
import org.training.itracker.service.IssueService;
import org.training.itracker.service.ProjectService;
import org.training.itracker.service.ResolutionService;
import org.training.itracker.service.StatusService;
import org.training.itracker.service.UserService;
import org.training.itracker.utilities.BackButton;
import org.training.itracker.utilities.CheckIssue;
import org.training.itracker.utilities.DAOException;

@Controller
public class IssueController {

	@Autowired
	private BuildService buildService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private IssueService issueService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ResolutionService resolutionService;

	@Autowired
	private StatusService statusService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/issue/{issueId}")
	public String beforeUpdate(HttpSession session, ModelMap model,
			@PathVariable("issueId") Issue issue) {

		model.addAttribute("issue", issue);

		List<Project> projects = projectService.getProjects();
		session.setAttribute(Constants.ATTRIBUTE_PROJECTS, projects);

		List<Resolution> resolutions = resolutionService.getResolutions();
		session.setAttribute(Constants.ATTRIBUTE_RESOLUTIONS, resolutions);

		BackButton.showBackHideSubmit(session);
		return "issueEdit";
	}

	@RequestMapping(value = "/updateIssue")
	public String update(
			HttpSession session,
			@RequestParam(value = "id") Issue issue,
			@RequestParam(value = "summary") String summary,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "status") Integer status,
			@RequestParam(value = "resolution", required = false) String tmpResolution,
			@RequestParam(value = "type") Integer type,
			@RequestParam(value = "priority") Integer priority,
			@RequestParam(value = "project") Integer project,
			@RequestParam(value = "build") Integer build,
			@RequestParam(value = "assignee") Integer assignee,
			@RequestParam(value = "comment") String commentText, ModelMap model) {

		User user = (User) session.getAttribute(Constants.ATTRIBUTE_USER);

		try {
			if (CheckIssue
					.checkIssue(statusService.getStatus(status), assignee)) {

				Resolution resolution = null;
				if (tmpResolution != null) {
					resolution = resolutionService.getResolution(Integer
							.parseInt(tmpResolution));
				}

				issue.setUserModify(user);
				java.util.Date utilDate = new java.util.Date();
				issue.setModifyDate(new java.sql.Date(utilDate.getTime()));
				issue.setSummary(summary);
				issue.setDescription(description);
				issue.setStatus(statusService.getStatus(status));
				issue.setResolution(resolution);
				issue.setProject(projectService.getProject(project));
				issue.setBuild(buildService.getBuild(build));
				issue.setAssignee(userService.getUser(assignee));
				issueService.updateIssue(issue);

				if (!commentText.equals("")) {
					Comment comment = new Comment();
					comment.setText(commentText);
					comment.setUser(user);
					comment.setIssue(issue);
					commentService.saveComment(comment);
				}

				model.addAttribute(Constants.SUCCESS,
						MessageConstants.ISSUE_UPDATED);
				return "forward:/main";
			}
		} catch (DAOException e) {
			model.addAttribute("issue", issue);
			model.addAttribute(MessageConstants.ERROR_MESSAGE, e.getMessage());
		}
		return "issueEdit";
	}

	@RequestMapping(value = "/submitIssue")
	public String submit(HttpSession session) {
		List<Project> projects = projectService.getProjects();
		session.setAttribute(Constants.ATTRIBUTE_PROJECTS, projects);
		session.setAttribute("firstProject", projectService.getProject(1));
		BackButton.showBackHideSubmit(session);
		return "issueSubmit";
	}

	@RequestMapping(value = "/saveIssue")
	public String save(HttpSession session,
			@RequestParam(value = "summary") String summary,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "status") Integer status,
			@RequestParam(value = "type") Integer type,
			@RequestParam(value = "priority") Integer priority,
			@RequestParam(value = "project") Integer project,
			@RequestParam(value = "build") Integer build,
			@RequestParam(value = "assignee") Integer assignee, ModelMap model) {

		try {
			if (CheckIssue
					.checkIssue(statusService.getStatus(status), assignee)) {

				User user = (User) session
						.getAttribute(Constants.ATTRIBUTE_USER);

				User userAssignee = userService.getUser(assignee);

				Issue issue = new Issue();
				issue.setUserCreation(user);
				issue.setSummary(summary);
				issue.setDescription(description);
				issue.setStatus(statusService.getStatus(status));
				issue.setType(type);
				issue.setPriority(priority);
				issue.setProject(projectService.getProject(project));
				issue.setBuild(buildService.getBuild(build));
				issue.setAssignee(userAssignee);
				issueService.saveIssue(issue);

				model.addAttribute(Constants.SUCCESS,
						MessageConstants.ISSUE_ADDED);

				return "forward:/main";
			}
		} catch (DAOException e) {
			model.addAttribute(MessageConstants.ERROR_MESSAGE, e.getMessage());
		}
		return "issueSubmit";
	}
}