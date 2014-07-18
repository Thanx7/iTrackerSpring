package org.training.itracker.dao.factories;

import org.training.itracker.dao.IssueDAOImpl;
import org.training.itracker.dao.IssueDAO;

public class IssueFactory {

	public static IssueDAO getClassFromFactory() {
		return new IssueDAOImpl();
	}
}