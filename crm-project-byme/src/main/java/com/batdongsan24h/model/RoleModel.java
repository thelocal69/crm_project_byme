package com.batdongsan24h.model;

import com.batdongsan24h.model.exte.AbstractModel;

public class RoleModel extends AbstractModel {
	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
