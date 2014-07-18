package org.training.itracker.dao;

import java.util.List;

import org.training.itracker.beans.Resolution;

public interface ResolutionDAO {

	Resolution getResolution(int id);

	List<Resolution> getResolutions();

	void saveResolution(Resolution resolution);

	void updateResolution(Resolution resolution);
}