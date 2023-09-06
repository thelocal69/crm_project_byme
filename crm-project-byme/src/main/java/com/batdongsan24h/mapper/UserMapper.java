package com.batdongsan24h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.batdongsan24h.mapper.impl.RowMapper;
import com.batdongsan24h.model.RoleModel;
import com.batdongsan24h.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel userModel = new UserModel();
			userModel.setId(rs.getInt("id"));
			userModel.setEmail(rs.getString("email"));
			userModel.setPass(rs.getString("pass"));
			userModel.setAvatar(rs.getString("avatar"));
			userModel.setFirstName(rs.getString("firstname"));
			userModel.setLastName(rs.getString("lastname"));
			userModel.setFullName(rs.getString("fullname"));
			userModel.setUserName(rs.getString("username"));
			userModel.setPhone(rs.getString("phone"));
			userModel.setRoleId(rs.getInt("role_id"));
			try {
				RoleModel roleModel = new RoleModel();
				roleModel.setName(rs.getString("rolename"));
				roleModel.setDescription(rs.getString("description"));
				userModel.setRoleModel(roleModel);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			userModel.setCreatedBy(rs.getString("createdby"));
			userModel.setCreatedDate(rs.getTimestamp("createddate"));
			if (userModel.getModifiedBy() != null) {
				userModel.setModifiedBy(rs.getString("modifiedby"));
			}
			if (userModel.getModifiedDate() != null) {
				userModel.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			return userModel;
		} catch (SQLException e) {
			return null;		}
	}
	}

