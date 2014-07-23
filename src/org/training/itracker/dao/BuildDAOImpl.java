package org.training.itracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.training.itracker.beans.Build;

@Repository
public class BuildDAOImpl implements BuildDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Build getBuild(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Build.class);
		criteria.add(Restrictions.eq("id", id));
		return (Build) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Build> getBuildList(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Build.class);
		criteria.add(Restrictions.eq("project.id", projectId));
		return criteria.list();
	}

	public void saveBuild(Build build) {
		sessionFactory.getCurrentSession().save(build);
	}
}