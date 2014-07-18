package org.training.itracker.utilities;

import org.apache.log4j.Logger;
import org.training.itracker.beans.Status;
import org.training.itracker.constants.MessageConstants;

public class CheckIssue {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(CheckIssue.class);

	public static boolean checkIssue(Status status, int assignee)
			throws DAOException {

		boolean emptyAssignee;
		if (assignee == 0) {
			emptyAssignee = true;
		} else {
			emptyAssignee = false;
		}

		boolean statusNew;
		if (status.getId() == 1) {
			statusNew = true;
		} else {
			statusNew = false;
		}

		if (statusNew && !emptyAssignee || !statusNew && emptyAssignee) {
			throw new DAOException(MessageConstants.ERROR_ASSIGNEE_WRONG_STATUS);
		}

		return true;
	}
}