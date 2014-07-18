package org.training.itracker.service;

import java.util.List;

import org.training.itracker.beans.Project;

public interface ProjectService {

	Project getProject(int id);

	List<Project> getProjects();

	void saveProject(Project project);

	void updateProject(Project project);
}