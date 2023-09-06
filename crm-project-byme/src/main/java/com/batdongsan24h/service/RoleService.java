package com.batdongsan24h.service;

import java.util.List;

import javax.inject.Inject;

import com.batdongsan24h.dao.impl.IRoleDao;
import com.batdongsan24h.model.RoleModel;
import com.batdongsan24h.service.impl.IRoleService;

public class RoleService implements IRoleService{
	
	@Inject
	private IRoleDao roleDao;

	@Override
	public List<RoleModel> findAll() {
		return roleDao.findAll();
	}

}
