package org.training.itracker.dao.factories;

import org.training.itracker.dao.UserDAOImpl;
import org.training.itracker.dao.UserDAO;

public class UserFactory {

	public static UserDAO getClassFromFactory() {
		// return new XmlUserImpl();
		return new UserDAOImpl();
	}
}