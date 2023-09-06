package com.batdongsan24h.service.impl;

import java.util.List;

import com.batdongsan24h.model.StatusModel;

public interface IStatusService {
	List<StatusModel> findAll();
	StatusModel findOne(Integer id);
}
