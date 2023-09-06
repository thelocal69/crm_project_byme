package com.batdongsan24h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.batdongsan24h.mapper.impl.RowMapper;
import com.batdongsan24h.model.ProjectModel;

public class ProjectMapper implements RowMapper<ProjectModel>{

	@Override
	public ProjectModel mapRow(ResultSet rs) {
		try {
			ProjectModel projectModel = new ProjectModel();
			projectModel.setId(rs.getInt("id"));
			projectModel.setProjectName(rs.getString("projectname"));
			projectModel.setStartedDate(rs.getString("starteddate"));
			projectModel.setEndedDate(rs.getString("endeddate"));
			projectModel.setCreatedBy(rs.getString("createdby"));
			projectModel.setCreatedDate(rs.getTimestamp("createddate"));
			if (projectModel.getModifiedBy() != null) {
				projectModel.setModifiedBy(rs.getString("modifiedby"));
			}
			if (projectModel.getModifiedDate() != null) {
				projectModel.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			return projectModel;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
