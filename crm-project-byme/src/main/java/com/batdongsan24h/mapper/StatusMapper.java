package com.batdongsan24h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.batdongsan24h.mapper.impl.RowMapper;
import com.batdongsan24h.model.StatusModel;

public class StatusMapper implements RowMapper<StatusModel>{

	@Override
	public StatusModel mapRow(ResultSet rs) {
		StatusModel statusModel = new StatusModel();
		try {
			statusModel.setId(rs.getInt("id"));
			statusModel.setName(rs.getString("statusname"));
			return statusModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
