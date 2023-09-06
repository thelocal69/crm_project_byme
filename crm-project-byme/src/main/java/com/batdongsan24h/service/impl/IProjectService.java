package com.batdongsan24h.service.impl;

import java.util.List;

import com.batdongsan24h.model.ProjectModel;

public interface IProjectService {
	
	List<ProjectModel> findAll();
	ProjectModel save(ProjectModel projectModel);
	ProjectModel update(ProjectModel projectModel);
	void deleteAll(Integer[] ids);
	void deleteById(Integer id);
	ProjectModel findOne(Integer id);
}
