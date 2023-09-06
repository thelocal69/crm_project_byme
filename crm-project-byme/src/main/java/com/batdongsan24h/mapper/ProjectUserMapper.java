package com.batdongsan24h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.batdongsan24h.mapper.impl.RowMapper;
import com.batdongsan24h.model.ProjectUserModel;

public class ProjectUserMapper implements RowMapper<ProjectUserModel> {

	@Override
	public ProjectUserModel mapRow(ResultSet rs) {
		try {
			ProjectUserModel projectUserModel = new ProjectUserModel();
			projectUserModel.setUserId(rs.getInt("user_id"));
			projectUserModel.setProjectId(rs.getInt("project_id"));
			projectUserModel.setCreatedBy(rs.getString("createdby"));
			projectUserModel.setCreatedDate(rs.getTimestamp("createddate"));
			if (projectUserModel.getModifiedBy() != null) {
				projectUserModel.setModifiedBy(rs.getString("modifiedby"));
			}
			if (projectUserModel.getModifiedDate() != null) {
				projectUserModel.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			return projectUserModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
