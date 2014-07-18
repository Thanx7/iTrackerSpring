package org.training.itracker.dao.factories;

import org.training.itracker.dao.CommentDAOImpl;
import org.training.itracker.dao.CommentDAO;

public class CommentFactory {

	public static CommentDAO getClassFromFactory() {
		return new CommentDAOImpl();
	}
}