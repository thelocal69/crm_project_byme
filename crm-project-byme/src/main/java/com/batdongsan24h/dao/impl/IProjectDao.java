package com.batdongsan24h.dao.impl;

import java.util.List;

import com.batdongsan24h.model.ProjectModel;

public interface IProjectDao {
	List<ProjectModel> findAll();
	ProjectModel findOne(Integer id);
	Integer save(ProjectModel projectModel);
	void update(ProjectModel projectModel);
	void delete(Integer id);
}
