package org.training.itracker.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.training.itracker.beans.Issue;
import org.training.itracker.service.IssueService;

public class StringToIssueConverter implements Converter<String, Issue> {

	@Autowired
	private IssueService issueService;

	@Override
	public Issue convert(String id) {
		try {
			return issueService.getIssue(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			return null;
		}
	}
}