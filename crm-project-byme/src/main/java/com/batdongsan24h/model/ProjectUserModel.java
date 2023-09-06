package com.batdongsan24h.model;

import com.batdongsan24h.model.exte.AbstractModel;

public class ProjectUserModel extends AbstractModel {
	private Integer userId;
	private Integer projectId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

}
