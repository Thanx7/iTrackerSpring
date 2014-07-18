package org.training.itracker.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.itracker.beans.User;
import org.training.itracker.dao.UserDAO;
import org.training.itracker.utilities.DAOException;

@Service
public class UserServiceImpl implements UserService {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	@Transactional
	public User getUser(String email, String password) throws DAOException {
		return userDAO.getUser(email, password);
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
}