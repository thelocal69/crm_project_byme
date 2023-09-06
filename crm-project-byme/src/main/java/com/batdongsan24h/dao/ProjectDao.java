package com.batdongsan24h.dao;

import java.util.List;

import com.batdongsan24h.dao.impl.AbstractDao;
import com.batdongsan24h.dao.impl.IProjectDao;
import com.batdongsan24h.mapper.ProjectMapper;
import com.batdongsan24h.model.ProjectModel;

public class ProjectDao extends AbstractDao<ProjectModel> implements IProjectDao {

	@Override
	public List<ProjectModel> findAll() {
		String sql = "SELECT * FROM project";
		return query(sql, new ProjectMapper());
	}

	@Override
	public Integer save(ProjectModel projectModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO project");
		sql.append(" (projectname, starteddate, endeddate, createdby, createddate)");
		sql.append(" VALUES (?, ?, ?, ?, ?)");
		return insert(sql.toString(), projectModel.getProjectName(), projectModel.getStartedDate(),
				projectModel.getEndedDate(), projectModel.getCreatedBy(), projectModel.getCreatedDate());
	}

	@Override
	public void update(ProjectModel projectModel) {
		StringBuilder sql = new StringBuilder("UPDATE project SET projectname=?, starteddate=?,");
		sql.append(" endeddate=?, createdby=?, createddate=?, modifiedby=?, modifieddate=? WHERE id=?");
		this.update(sql.toString(), projectModel.getProjectName(), projectModel.getStartedDate(),
				projectModel.getEndedDate(), projectModel.getCreatedBy(), projectModel.getCreatedDate(),
				projectModel.getModifiedBy(), projectModel.getModifiedDate(), projectModel.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM project WHERE id =?";
		this.update(sql, id);
	}

	@Override
	public ProjectModel findOne(Integer id) {
		String sql = "SELECT * FROM project WHERE id=?";
		List<ProjectModel> listProject = query(sql, new ProjectMapper(), id);
		return listProject.isEmpty() ? null : listProject.get(0);
	}

}
