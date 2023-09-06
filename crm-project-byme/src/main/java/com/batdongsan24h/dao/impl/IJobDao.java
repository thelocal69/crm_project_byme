package com.batdongsan24h.dao.impl;

import java.util.List;

import com.batdongsan24h.model.JobModel;

public interface IJobDao {
	List<JobModel> findAll();
	JobModel findOne(Integer id);
	Integer save(JobModel jobModel);
	void update(JobModel jobModel);
	void delete(Integer id);
}
