package org.training.itracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.itracker.beans.Issue;
import org.training.itracker.dao.IssueDAO;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueDAO issueDAO;

	public void setIssueDAO(IssueDAO issueDAO) {
		this.issueDAO = issueDAO;
	}

	@Transactional
	public Issue getIssue(int id) {
		return issueDAO.getIssue(id);
	}

	@Transactional
	public Integer getIssues() {
		return issueDAO.getIssues();
	}

	@Transactional
	public List<Issue> getIssues(Integer pageNumber, String sort) {
		return issueDAO.getIssues(pageNumber, sort);
	}

	@Transactional
	public void saveIssue(Issue issue) {
		issueDAO.saveIssue(issue);
	}

	@Transactional
	public void updateIssue(Issue issue) {
		issueDAO.updateIssue(issue);
	}
}