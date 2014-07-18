package org.training.itracker.dao;

import java.util.List;

import org.training.itracker.beans.Build;

public interface BuildDAO {

	Build getBuild(int id);

	List<Build> getBuildList(int project);

	void saveBuild(Build build);
}
