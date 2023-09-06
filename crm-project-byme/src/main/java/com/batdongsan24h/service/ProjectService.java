package com.batdongsan24h.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.batdongsan24h.dao.impl.IProjectDao;
import com.batdongsan24h.model.ProjectModel;
import com.batdongsan24h.service.impl.IProjectService;

public class ProjectService implements IProjectService{
	
	@Inject
	private IProjectDao projectDao;
	
	@Override
	public List<ProjectModel> findAll() {
		return projectDao.findAll();
	}

	@Override
	public ProjectModel save(ProjectModel projectModel) {
		projectModel.setCreatedDate(new java.sql.Timestamp(System.currentTimeMillis()));
		this.projectDao.save(projectModel);
		return projectModel;
	}

	@Override
	public ProjectModel update(ProjectModel projectModel) {
		ProjectModel oldProject = projectDao.findOne(projectModel.getId());
		projectModel.setCreatedBy(oldProject.getCreatedBy());
		projectModel.setCreatedDate(oldProject.getCreatedDate());
		projectModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		this.projectDao.update(projectModel);
		return projectModel;
	}

	@Override
	public ProjectModel findOne(Integer id) {
		return projectDao.findOne(id);
	}

	@Override
	public void deleteAll(Integer[] ids) {
		for (Integer id : ids) {
			this.projectDao.delete(id);
		}		
	}

	@Override
	public void deleteById(Integer id) {
		this.projectDao.delete(id);
	}
	
}
