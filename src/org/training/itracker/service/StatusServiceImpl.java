package org.training.itracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.itracker.beans.Status;
import org.training.itracker.dao.StatusDAO;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusDAO statusDAO;

	@Transactional
	public Status getStatus(int id) {
		return statusDAO.getStatus(id);
	}

	@Transactional
	public List<Status> getStatuses() {
		return statusDAO.getStatuses();
	}

	@Transactional
	public void updateStatus(Status status) {
		statusDAO.updateStatus(status);
	}
}