package org.training.itracker.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.itracker.beans.Build;
import org.training.itracker.beans.Project;
import org.training.itracker.beans.User;
import org.training.itracker.constants.Constants;
import org.training.itracker.service.BuildService;
import org.training.itracker.service.ProjectService;
import org.training.itracker.service.UserService;
import org.training.itracker.utilities.BackButton;

import com.google.gson.Gson;

@Controller
public class ProjectController {

	@Autowired
	private BuildService buildService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/projects")
	public String projects(HttpSession session) {
		List<Project> allProjects;
		allProjects = projectService.getProjects();
		session.setAttribute(Constants.ATTRIBUTE_PROJECTS, allProjects);

		BackButton.showBackHideSubmit(session);
		return "projects";
	}

	@RequestMapping(value = "/project/{id}")
	public String project(HttpSession session,
			@PathVariable(value = "id") int id) {
		Project project = projectService.getProject(id);
		session.setAttribute(Constants.ATTRIBUTE_PROJECT, project);

		BackButton.showBackHideSubmit(session);
		return "projectEdit";
	}

	@RequestMapping(value = "/updateProject")
	public String updateProject(HttpSession session,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "manager") int manager,
			@RequestParam(value = "newBuild") String newBuild) {

		Project project = (Project) session
				.getAttribute(Constants.ATTRIBUTE_PROJECT);

		User userManager = userService.getUser(manager);

		project.setProjectName(name);
		project.setDescription(description);
		project.setManager(userManager);
		projectService.updateProject(project);

		if (!newBuild.equals("")) {
			Build build = new Build();
			build.setName(newBuild);
			build.setProject(project);
			buildService.saveBuild(build);
		}
		return "forward:/projects";
	}

	@RequestMapping(value = "/projectSubmit")
	public String addProject(HttpSession session) {
		BackButton.showBackHideSubmit(session);
		return "projectSubmit";
	}

	@RequestMapping(value = "/saveProject")
	public String saveProject(HttpSession session,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "manager") int manager,
			@RequestParam(value = "buildName") String buildName) {

		User userManager = userService.getUser(manager);

		Project project = new Project();
		project.setProjectName(name);
		project.setDescription(description);
		project.setManager(userManager);

		Build build = new Build();
		build.setName(buildName);
		build.setProject(project);

		projectService.saveProject(project);
		buildService.saveBuild(build);
		return "forward:/projects";
	}

	@RequestMapping(value = "/dropdown2options")
	public void buildDropdown(HttpSession session,
			HttpServletResponse response,
			@RequestParam(value = "value") int projectId) {

		List<Build> buildsProject = buildService.getBuildList(projectId);
		Map<String, String> options = new HashMap<>();

		for (Build b : buildsProject) {
			options.put(Integer.toString(b.getId()), b.getName());
		}

		String json = new Gson().toJson(options);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}