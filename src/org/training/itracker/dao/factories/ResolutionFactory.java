package org.training.itracker.dao.factories;

import org.training.itracker.dao.ResolutionDAOImpl;
import org.training.itracker.dao.ResolutionDAO;

public class ResolutionFactory {

	public static ResolutionDAO getClassFromFactory() {
		return new ResolutionDAOImpl();
	}
}