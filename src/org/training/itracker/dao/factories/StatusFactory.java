package org.training.itracker.dao.factories;

import org.training.itracker.dao.StatusDAOImpl;
import org.training.itracker.dao.StatusDAO;

public class StatusFactory {

	public static StatusDAO getClassFromFactory() {
		return new StatusDAOImpl();
	}
}