package org.training.itracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.training.itracker.beans.Build;
import org.training.itracker.constants.Constants;

@Repository
public class BuildDAOImpl implements BuildDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Build getBuild(int id) {
		Build build = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Build.class);
			criteria.add(Restrictions.eq(Constants.ID, id));
			build = (Build) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return build;
	}

	@SuppressWarnings("unchecked")
	public List<Build> getBuildList(int projectId) {
		List<Build> builds = new ArrayList<>();

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Build.class);
			criteria.add(Restrictions.eq("project.id", projectId));
			builds = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return builds;
	}

	public void saveBuild(Build build) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(build);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}