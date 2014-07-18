package org.training.itracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.training.itracker.beans.Issue;
import org.training.itracker.constants.Constants;

@Repository
public class IssueDAOImpl implements IssueDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Issue getIssue(int id) {
		Issue issue = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Issue.class);
			criteria.add(Restrictions.eq(Constants.ID, id));
			issue = (Issue) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return issue;
	}

	@SuppressWarnings("unchecked")
	public List<Issue> getAllIssues(String sort) {
		List<Issue> issues = new ArrayList<>();

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Issue.class);
			switch (sort) {
			case Constants.ID:
				criteria = criteria.addOrder(Order.asc(Constants.ID));
				break;
			case "priority":
				criteria = criteria.addOrder(Order.asc("priority"));
				break;
			case "assignee":
				criteria = criteria.addOrder(Order.asc("assignee"));
				break;
			case "type":
				criteria = criteria.addOrder(Order.asc("type"));
				break;
			case "status":
				criteria = criteria.addOrder(Order.asc("status"));
				break;
			case "summary":
				criteria = criteria.addOrder(Order.asc("summary"));
				break;
			}

			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			issues = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return issues;
	}

	public List<Issue> getAllIssues() {
		return getAllIssues(Constants.ID);
	}

	public void saveIssue(Issue issue) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(issue);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateIssue(Issue issue) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.update(issue);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}