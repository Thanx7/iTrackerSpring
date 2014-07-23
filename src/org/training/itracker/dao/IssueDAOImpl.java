package org.training.itracker.dao;

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

@Repository
public class IssueDAOImpl implements IssueDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Issue getIssue(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Issue.class);
		criteria.add(Restrictions.eq("id", id));
		return (Issue) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Issue> getAllIssues(String sort) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Issue.class);

		switch (sort) {
		case "id":
			criteria = criteria.addOrder(Order.asc("id"));
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
		return criteria.list();
	}

	public List<Issue> getAllIssues() {
		return getAllIssues("id");
	}

	public void saveIssue(Issue issue) {
		sessionFactory.getCurrentSession().save(issue);
	}

	public void updateIssue(Issue issue) {
		sessionFactory.getCurrentSession().update(issue);
	}
}