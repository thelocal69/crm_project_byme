package com.batdongsan24h.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.batdongsan24h.dao.impl.IJobDao;
import com.batdongsan24h.dao.impl.IProjectDao;
import com.batdongsan24h.dao.impl.IStatusDao;
import com.batdongsan24h.dao.impl.IUserDao;
import com.batdongsan24h.model.JobModel;
import com.batdongsan24h.model.ProjectModel;
import com.batdongsan24h.model.StatusModel;
import com.batdongsan24h.model.UserModel;
import com.batdongsan24h.service.impl.IJobService;

public class JobService implements IJobService{
	
	@Inject
	private IJobDao jobDao;
	
	@Inject
	private IProjectDao projectDao;
	
	@Inject
	private IUserDao userDao;
	
	@Inject
	private IStatusDao statusDao;

	@Override
	public List<JobModel> findAll() {
		return jobDao.findAll();
	}

	@Override
	public JobModel findOne(Integer id) {
		return jobDao.findOne(id);
	}

	@Override
	public JobModel save(JobModel jobModel) {
		jobModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		ProjectModel projectModel = projectDao.findOne(jobModel.getProjectId());
		UserModel userModel = userDao.findOne(jobModel.getUserId());
		StatusModel statusModel = statusDao.findOne(jobModel.getStatusId());
		jobModel.setProjectId(projectModel.getId());
		jobModel.setUserId(userModel.getId());
		jobModel.setStatusId(statusModel.getId());	
		jobDao.save(jobModel);
		return jobModel;
	}

	@Override
	public JobModel update(JobModel jobModel) {
		JobModel oldJob = jobDao.findOne(jobModel.getId());
		jobModel.setCreatedBy(oldJob.getCreatedBy());
		jobModel.setCreatedDate(oldJob.getCreatedDate());
		jobModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		ProjectModel projectModel = projectDao.findOne(jobModel.getProjectId());
		UserModel userModel = userDao.findOne(jobModel.getUserId());
		StatusModel statusModel = statusDao.findOne(jobModel.getStatusId());
		jobModel.setProjectId(projectModel.getId());
		jobModel.setUserId(userModel.getId());
		jobModel.setStatusId(statusModel.getId());
		jobDao.update(jobModel);
		return jobModel;
	}

	@Override
	public void deleteById(Integer id) {
		this.jobDao.delete(id);
	}

}
