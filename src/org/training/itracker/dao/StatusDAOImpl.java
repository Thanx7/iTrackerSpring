package org.training.itracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.training.itracker.beans.Status;
import org.training.itracker.constants.Constants;

@Repository
public class StatusDAOImpl implements StatusDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Status getStatus(int id) {
		Status status = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Status.class);
			criteria.add(Restrictions.eq(Constants.ID, id));
			status = (Status) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@SuppressWarnings("unchecked")
	public List<Status> getStatuses() {
		List<Status> statuses = new ArrayList<>();

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Status.class);
			statuses = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return statuses;
	}

	public void updateStatus(Status status) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.update(status);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}