package com.batdongsan24h.dao;

import java.util.List;

import com.batdongsan24h.dao.impl.AbstractDao;
import com.batdongsan24h.dao.impl.IStatusDao;
import com.batdongsan24h.mapper.StatusMapper;
import com.batdongsan24h.model.StatusModel;

public class StatusDao extends AbstractDao<StatusModel> implements IStatusDao{

	@Override
	public List<StatusModel> findAll() {
		String sql = "SELECT * FROM status";
		return query(sql, new StatusMapper());
	}

	@Override
	public StatusModel findOne(Integer id) {
		String sql = "SELECT * FROM status WHERE id=?";
		List<StatusModel> listStatus = query(sql, new StatusMapper(), id);
		return listStatus.isEmpty()?null:listStatus.get(0);
	}
	
}
