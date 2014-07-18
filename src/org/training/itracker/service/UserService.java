package org.training.itracker.service;

import java.util.List;

import org.training.itracker.beans.User;
import org.training.itracker.utilities.DAOException;

public interface UserService {

	User getUser(int id);

	User getUser(String email, String password) throws DAOException;

	List<User> getAllUsers();
	// User getRegisteredUser(String email, String password) throws
	// DaoException;
}