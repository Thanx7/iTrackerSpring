package org.training.itracker.service;

import java.util.List;

import org.training.itracker.beans.Resolution;

public interface ResolutionService {

	Resolution getResolution(int id);

	List<Resolution> getResolutions();

	void saveResolution(Resolution resolution);

	void updateResolution(Resolution resolution);
}