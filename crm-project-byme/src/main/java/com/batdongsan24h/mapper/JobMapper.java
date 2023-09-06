package com.batdongsan24h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.batdongsan24h.mapper.impl.RowMapper;
import com.batdongsan24h.model.JobModel;
import com.batdongsan24h.model.ProjectModel;
import com.batdongsan24h.model.StatusModel;
import com.batdongsan24h.model.UserModel;

public class JobMapper implements RowMapper<JobModel> {

	@Override
	public JobModel mapRow(ResultSet rs) {
		try {
			JobModel jobModel = new JobModel();
			jobModel.setId(rs.getInt("id"));
			jobModel.setName(rs.getString("name"));
			jobModel.setContent(rs.getString("content"));
			jobModel.setStartedDate(rs.getString("starteddate"));
			jobModel.setEndedDate(rs.getString("endeddate"));
			jobModel.setProjectId(rs.getInt("project_id"));
			jobModel.setUserId(rs.getInt("user_id"));
			jobModel.setStatusId(rs.getInt("status_id"));
			try {
				ProjectModel projectModel = new ProjectModel();
				projectModel.setProjectName(rs.getString("projectname"));
				jobModel.setProjectModel(projectModel);
			} catch (SQLException e) {
				e.getMessage();
			}
			
			try {
				UserModel userModel = new UserModel();
				userModel.setFullName(rs.getString("fullname"));
				jobModel.setUserModel(userModel);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				StatusModel statusModel = new StatusModel();
				statusModel.setName(rs.getString("statusname"));
				jobModel.setStatusModel(statusModel);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			jobModel.setCreatedBy(rs.getString("createdby"));
			jobModel.setCreatedDate(rs.getTimestamp("createddate"));
			if (jobModel.getModifiedBy() != null) {
				jobModel.setModifiedBy(rs.getString("modifiedby"));
			}
			if (jobModel.getModifiedDate() != null) {
				jobModel.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			return jobModel;
		} catch (SQLException e) {
			return null;
}
		}
	}
