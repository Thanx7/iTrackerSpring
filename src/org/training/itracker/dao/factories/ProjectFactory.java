package org.training.itracker.dao.factories;

import org.training.itracker.dao.ProjectDAOImpl;
import org.training.itracker.dao.ProjectDAO;

public class ProjectFactory {

	public static ProjectDAO getClassFromFactory() {
		return new ProjectDAOImpl();
	}
}