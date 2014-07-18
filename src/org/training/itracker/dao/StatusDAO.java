package org.training.itracker.dao;

import java.util.List;

import org.training.itracker.beans.Status;

public interface StatusDAO {

	Status getStatus(int id);

	List<Status> getStatuses();

	void updateStatus(Status status);
}