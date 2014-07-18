package org.training.itracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.itracker.beans.Issue;
import org.training.itracker.constants.Constants;
import org.training.itracker.dao.IssueDAO;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueDAO issueDAO;

	@Transactional
	public Issue getIssue(int id) {
		return issueDAO.getIssue(id);
	}

	@Transactional
	public List<Issue> getAllIssues(String sort) {
		return issueDAO.getAllIssues(sort);
	}

	@Transactional
	public List<Issue> getAllIssues() {
		return issueDAO.getAllIssues(Constants.ID);
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