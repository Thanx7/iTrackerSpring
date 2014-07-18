package org.training.itracker.dao.factories;

import org.training.itracker.dao.BuildDAOImpl;
import org.training.itracker.dao.BuildDAO;

public class BuildFactory {

	public static BuildDAO getClassFromFactory() {
		return new BuildDAOImpl();
	}
}