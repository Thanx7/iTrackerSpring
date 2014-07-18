package org.training.itracker.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "PROJECT_NAME", nullable = false)
	private String projectName;

	@Column(nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID", nullable = false)
	private User manager;

	@OneToMany(targetEntity = Build.class, mappedBy = "project", fetch = FetchType.EAGER)
	private List<Build> buildList = new ArrayList<>();

	public Project() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public List<Build> getBuildList() {
		return buildList;
	}

	public void setBuildList(List<Build> buildList) {
		this.buildList = buildList;
	}
}