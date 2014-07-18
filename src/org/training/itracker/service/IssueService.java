package org.training.itracker.service;

import java.util.List;

import org.training.itracker.beans.Issue;

public interface IssueService {

	Issue getIssue(int id);

	List<Issue> getAllIssues();

	List<Issue> getAllIssues(String sort);

	void saveIssue(Issue issue);

	void updateIssue(Issue issue);
}