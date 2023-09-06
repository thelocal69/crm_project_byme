package com.batdongsan24h.dao;

import java.util.List;

import com.batdongsan24h.dao.impl.AbstractDao;
import com.batdongsan24h.dao.impl.IRoleDao;
import com.batdongsan24h.mapper.RoleMapper;
import com.batdongsan24h.model.RoleModel;

public class RoleDao extends AbstractDao<RoleModel> implements IRoleDao{

	@Override
	public RoleModel findOneByName(String name) {
		String sql = "SELECT * FROM role WHERE name = ?";
		List<RoleModel> listRole = query(sql, new RoleMapper(), name);
		return (listRole.isEmpty())?null:listRole.get(0);
	}

	@Override
	public RoleModel findOne(Integer id) {
		String sql = "SELECT * FROM role WHERE id = ?";
		List<RoleModel> listRoleModel = query(sql, new RoleMapper(), id);
		return (listRoleModel.isEmpty())?null:listRoleModel.get(0);
	}

	@Override
	public List<RoleModel> findAll() {
		String sql = "SELECT * FROM role";
		return query(sql, new RoleMapper());
	}

}
