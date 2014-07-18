package org.training.itracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.training.itracker.beans.User;
import org.training.itracker.constants.Constants;
import org.training.itracker.utilities.DAOException;
import org.training.itracker.utilities.Validation;

@Repository
public class UserDAOImpl implements UserDAO {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public User getUser(int id) {
		User user = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq(Constants.ID, id));
			user = (User) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public User getUser(String email, String password) throws DAOException {
		User user = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq(Constants.EMAIL, email));
			user = (User) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Validation.login(user, password);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();

		try {
			Session session = sessionFactory.getCurrentSession();
			users = session.createCriteria(User.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}
}