package org.training.itracker.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
public class Issue implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Generated(GenerationTime.INSERT)
	@Column(name = "DATE_CREATION", insertable = false, nullable = false)
	private Date dateCreation;

	@ManyToOne
	@JoinColumn(name = "USER_CREATION_ID", referencedColumnName = "ID", nullable = false)
	private User userCreation;

	@Column(name = "DATE_MODIFY")
	private Date modifyDate;

	@ManyToOne
	@JoinColumn(name = "USER_MODIFY_ID", referencedColumnName = "ID")
	private User userModify;

	@Column(nullable = false)
	private String summary;

	@Column(nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "ID", nullable = false)
	private Status status;

	@ManyToOne
	@JoinColumn(name = "RESOLUTION_ID", referencedColumnName = "ID")
	private Resolution resolution;

	@Column(name = "TYPE_ID", nullable = false)
	private int type;

	@Column(name = "PRIORITY_ID", nullable = false)
	private int priority;

	@ManyToOne
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID", nullable = false)
	private Project project;

	@ManyToOne
	@JoinColumn(name = "BUILD_ID", referencedColumnName = "ID", nullable = false)
	private Build build;

	@ManyToOne
	@JoinColumn(name = "ASSIGNEE_ID", referencedColumnName = "ID")
	private User assignee;

	@OneToMany(targetEntity = Comment.class, mappedBy = "issue", fetch = FetchType.EAGER)
	private List<Comment> commentList = new ArrayList<>();

	public Issue() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public User getUserCreation() {
		return userCreation;
	}

	public void setUserCreation(User userCreation) {
		this.userCreation = userCreation;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public User getUserModify() {
		return userModify;
	}

	public void setUserModify(User userModify) {
		this.userModify = userModify;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Resolution getResolution() {
		return resolution;
	}

	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", dateCreation=" + dateCreation
				+ ", userCreation=" + userCreation + ", modifyDate="
				+ modifyDate + ", userModify=" + userModify + ", summary="
				+ summary + ", description=" + description + ", status="
				+ status + ", resolution=" + resolution + ", type=" + type
				+ ", priority=" + priority + ", project=" + project
				+ ", build=" + build + ", assignee=" + assignee
				+ ", commentList=" + commentList + "]";
	}

}