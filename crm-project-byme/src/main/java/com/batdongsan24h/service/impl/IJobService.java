package com.batdongsan24h.service.impl;

import java.util.List;

import com.batdongsan24h.model.JobModel;

public interface IJobService {
	List<JobModel> findAll();
	JobModel findOne(Integer id);
	JobModel save(JobModel jobModel);
	JobModel update(JobModel jobModel);
	void deleteById(Integer id);
	
}
