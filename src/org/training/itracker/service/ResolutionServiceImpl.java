package org.training.itracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.itracker.beans.Resolution;
import org.training.itracker.dao.ResolutionDAO;

@Service
public class ResolutionServiceImpl implements ResolutionService {

	@Autowired
	private ResolutionDAO resolutionDAO;

	@Transactional
	public Resolution getResolution(int id) {
		return resolutionDAO.getResolution(id);
	}

	@Transactional
	public void saveResolution(Resolution resolution) {
		resolutionDAO.saveResolution(resolution);
	}

	@Transactional
	public void updateResolution(Resolution resolution) {
		resolutionDAO.updateResolution(resolution);
	}

	@Transactional
	public List<Resolution> getResolutions() {
		return resolutionDAO.getResolutions();
	}
}