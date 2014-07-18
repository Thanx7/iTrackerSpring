package org.training.itracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.itracker.beans.Build;
import org.training.itracker.dao.BuildDAO;

@Service
public class BuildServiceImpl implements BuildService {

	@Autowired
	private BuildDAO buildDAO;

	@Transactional
	public Build getBuild(int id) {
		return buildDAO.getBuild(id);
	}

	@Transactional
	public List<Build> getBuildList(int projectId) {
		return buildDAO.getBuildList(projectId);
	}

	@Transactional
	public void saveBuild(Build build) {
		buildDAO.saveBuild(build);
	}
}