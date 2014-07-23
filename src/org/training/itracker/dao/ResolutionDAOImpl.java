package org.training.itracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.training.itracker.beans.Resolution;

@Repository
public class ResolutionDAOImpl implements ResolutionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Resolution getResolution(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Resolution.class);
		criteria.add(Restrictions.eq("id", id));
		return (Resolution) criteria.uniqueResult();
	}

	public void saveResolution(Resolution resolution) {
		sessionFactory.getCurrentSession().save(resolution);
	}

	public void updateResolution(Resolution resolution) {
		sessionFactory.getCurrentSession().update(resolution);
	}

	@SuppressWarnings("unchecked")
	public List<Resolution> getResolutions() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Resolution.class);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
}