package org.training.itracker.service;

import java.util.List;

import org.training.itracker.beans.Status;

public interface StatusService {

	Status getStatus(int id);

	List<Status> getStatuses();

	void updateStatus(Status status);
}