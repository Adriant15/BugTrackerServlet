package com.ato.web.model;

public class Bug {
	private int id;
	private String title;
	private String issue;
	private String reporter;
	private String created;
	private String due;
	private Severity severity;
	private BugStatus status;

	public Bug(int id, String title, String issue, String reporter, String created, String due, Severity severity, BugStatus status) {
		this.id = id;
		this.title = title;
		this.issue = issue;
		this.reporter = reporter;
		this.created = created;
		this.due = due;
		this.severity = severity;
		this.status = status;
	}

	public Bug(String title, String issue, String reporter, String created, String due, Severity severity, BugStatus status) {
		this.title = title;
		this.issue = issue;
		this.reporter = reporter;
		this.created = created;
		this.due = due;
		this.severity = severity;
		this.status = status;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public BugStatus getStatus() {
		return status;
	}

	public void setStatus(BugStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Bug [id=" + id + ", title=" + title + ", issue=" + issue + ", reporter=" + reporter + ", created="
				+ created + ", due=" + due + ", severity=" + severity + ", status=" + status + "]";
	}
}
