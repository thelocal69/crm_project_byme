package com.batdongsan24h.service;

import java.util.List;

import javax.inject.Inject;

import com.batdongsan24h.dao.impl.IStatusDao;
import com.batdongsan24h.model.StatusModel;
import com.batdongsan24h.service.impl.IStatusService;

public class StatusService implements IStatusService{
	
	@Inject
	private IStatusDao statusDao;

	@Override
	public List<StatusModel> findAll() {
		return statusDao.findAll();
	}

	@Override
	public StatusModel findOne(Integer id) {
		return statusDao.findOne(id);
	}

}
