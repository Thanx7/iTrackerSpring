package org.training.itracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.training.itracker.beans.Project;
import org.training.itracker.constants.Constants;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Project getProject(int id) {
		Project project = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Project.class);
			criteria.add(Restrictions.eq(Constants.ID, id));
			project = (Project) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return project;
	}

	public void saveProject(Project project) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(project);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProject(Project project) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.update(project);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Project> getProjects() {
		List<Project> projects = new ArrayList<>();

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Project.class);
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			projects = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return projects;
	}
}