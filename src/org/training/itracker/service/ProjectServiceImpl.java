package org.training.itracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.itracker.beans.Project;
import org.training.itracker.dao.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Transactional
	public Project getProject(int id) {
		return projectDAO.getProject(id);
	}

	@Transactional
	public void saveProject(Project project) {
		projectDAO.saveProject(project);
	}

	@Transactional
	public void updateProject(Project project) {
		projectDAO.updateProject(project);
	}

	@Transactional
	public List<Project> getProjects() {
		return projectDAO.getProjects();
	}
}