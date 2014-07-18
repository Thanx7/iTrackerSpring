package org.training.itracker.dao;

import java.util.List;

import org.training.itracker.beans.Project;

public interface ProjectDAO {

	Project getProject(int id);

	List<Project> getProjects();

	void saveProject(Project project);

	void updateProject(Project project);
}