package org.training.itracker.service;

import java.util.List;

import org.training.itracker.beans.Build;

public interface BuildService {

	Build getBuild(int id);

	List<Build> getBuildList(int project);

	void saveBuild(Build build);
}
