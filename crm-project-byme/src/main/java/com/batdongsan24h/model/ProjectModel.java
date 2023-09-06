package com.batdongsan24h.model;

import com.batdongsan24h.model.exte.AbstractModel;

public class ProjectModel extends AbstractModel{
	private String projectName;
	private String startedDate;
	private String endedDate;

	

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(String startedDate) {
		this.startedDate = startedDate;
	}

	public String getEndedDate() {
		return endedDate;
	}

	public void setEndedDate(String endedDate) {
		this.endedDate = endedDate;
	}


}
