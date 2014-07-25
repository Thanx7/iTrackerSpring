package org.training.itracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
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
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Issue.class);
		criteria.add(Restrictions.eq("id", id));
		return (Issue) criteria.uniqueResult();
	}

	public Integer getIssues() {
		return sessionFactory
				.getCurrentSession()
				.createCriteria(Issue.class)
				.setResultTransformer(
						CriteriaSpecification.DISTINCT_ROOT_ENTITY).list()
				.size();
	}

	@SuppressWarnings("unchecked")
	public List<Issue> getIssues(Integer pageNumber, String sort) {
		Session session = sessionFactory.getCurrentSession();
		Query q = null;
		if (sort == null) {
			q = session.createQuery("from Issue order by id desc");
		} else {
			switch (sort) {
			case "priority":
				q = session.createQuery("from Issue order by priority desc");
				break;
			case "assignee":
				q = session.createQuery("from Issue order by assignee desc");
				break;
			case "type":
				q = session.createQuery("from Issue order by type desc");
				break;
			case "status":
				q = session.createQuery("from Issue order by status desc");
				break;
			case "summary":
				q = session.createQuery("from Issue order by summary desc");
				break;
			default:
				q = session.createQuery("from Issue order by id desc");
				break;
			}
		}
		q.setFirstResult(pageNumber * Constants.ISSUES_ON_PAGE);
		q.setMaxResults(Constants.ISSUES_ON_PAGE);
		return q.list();
	}

	public void saveIssue(Issue issue) {
		sessionFactory.getCurrentSession().save(issue);
	}

	public void updateIssue(Issue issue) {
		sessionFactory.getCurrentSession().update(issue);
	}
}