package com.batdongsan24h.dao.impl;

import java.util.List;

import com.batdongsan24h.model.StatusModel;

public interface IStatusDao {
	List<StatusModel> findAll();
	StatusModel findOne(Integer id);
}
