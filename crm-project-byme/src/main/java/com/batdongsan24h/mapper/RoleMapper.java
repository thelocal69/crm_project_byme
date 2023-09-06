package com.batdongsan24h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.batdongsan24h.mapper.impl.RowMapper;
import com.batdongsan24h.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel>{

	@Override
	public RoleModel mapRow(ResultSet rs) {
		try {
			RoleModel roleModel = new RoleModel();
			roleModel.setId(rs.getInt("id"));
			roleModel.setName(rs.getString("rolename"));
			roleModel.setDescription(rs.getString("description"));
			roleModel.setCreatedBy(rs.getString("createdby"));
			roleModel.setCreatedDate(rs.getTimestamp("createddate"));
			if (roleModel.getModifiedBy() != null) {
				roleModel.setModifiedBy(rs.getString("modifiedby"));
			}
			if (roleModel.getModifiedDate() != null) {
				roleModel.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			return roleModel;
		} catch (SQLException e) {
			return null;
		}
	}
}
