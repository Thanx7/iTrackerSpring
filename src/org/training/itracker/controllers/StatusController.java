package org.training.itracker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.itracker.beans.Status;
import org.training.itracker.constants.Constants;
import org.training.itracker.service.StatusService;
import org.training.itracker.utilities.BackButton;

@Controller
public class StatusController {

	@Autowired
	private StatusService statusService;

	@RequestMapping(value = "/statuses")
	public String statuses(HttpSession session) {
		List<Status> statuses;
		statuses = statusService.getStatuses();
		session.setAttribute(Constants.ATTRIBUTE_STATUSES, statuses);

		BackButton.showBackHideSubmit(session);
		return "statuses";
	}

	@RequestMapping(value = "/status")
	public String statusEdit(HttpSession session,
			@RequestParam(value = "id") int id) {
		Status status = statusService.getStatus(id);
		session.setAttribute(Constants.ATTRIBUTE_STATUS, status);

		BackButton.showBackHideSubmit(session);
		return "statusEdit";
	}

	@RequestMapping(value = "/updateStatus")
	public String updateStatus(HttpSession session,
			@RequestParam(value = "name") String name) {

		Status status = (Status) session
				.getAttribute(Constants.ATTRIBUTE_STATUS);

		status.setStatusCode(name);
		statusService.updateStatus(status);

		return "forward:/statuses";
	}
}