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
import org.training.itracker.beans.Resolution;
import org.training.itracker.constants.Constants;

@Repository
public class ResolutionDAOImpl implements ResolutionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Resolution getResolution(int id) {
		Resolution resolution = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Resolution.class);
			criteria.add(Restrictions.eq(Constants.ID, id));
			resolution = (Resolution) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resolution;
	}

	public void saveResolution(Resolution resolution) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(resolution);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateResolution(Resolution resolution) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.update(resolution);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Resolution> getResolutions() {
		List<Resolution> resolutions = new ArrayList<>();

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Resolution.class);
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			resolutions = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resolutions;
	}
}