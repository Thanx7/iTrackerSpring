package org.training.itracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.training.itracker.beans.Status;

@Repository
public class StatusDAOImpl implements StatusDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Status getStatus(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Status.class);
		criteria.add(Restrictions.eq("id", id));
		return (Status) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Status> getStatuses() {
		return sessionFactory.getCurrentSession().createCriteria(Status.class)
				.list();
	}

	public void updateStatus(Status status) {
		sessionFactory.getCurrentSession().update(status);
	}
}