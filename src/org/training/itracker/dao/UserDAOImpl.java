package org.training.itracker.dao;

import java.util.List;

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

@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {

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

		System.out.println(sessionFactory.getCurrentSession()
				.createCriteria(User.class).list());
		System.out.println("sessionFactory: " + sessionFactory);
		System.out.println("sessionFactory.getCurrentSession(): "
				+ sessionFactory.getCurrentSession());
		System.out.println();

		return sessionFactory.getCurrentSession().createCriteria(User.class)
				.list();
	}
}