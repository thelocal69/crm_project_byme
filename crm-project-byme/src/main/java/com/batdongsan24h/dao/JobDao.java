package com.batdongsan24h.dao;

import java.util.List;

import com.batdongsan24h.dao.impl.AbstractDao;
import com.batdongsan24h.dao.impl.IJobDao;
import com.batdongsan24h.mapper.JobMapper;
import com.batdongsan24h.model.JobModel;

public class JobDao extends AbstractDao<JobModel> implements IJobDao {

	@Override
	public List<JobModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM job AS j");
		sql.append(" JOIN project AS p ON j.project_id = p.id");
		sql.append(" JOIN user AS u ON j.user_id = u.id");
		sql.append(" JOIN status AS s ON j.status_id = s.id");
		return query(sql.toString(), new JobMapper());
	}

	@Override
	public JobModel findOne(Integer id) {
		String sql = "SELECT * FROM job WHERE id=?";
		List<JobModel> listJob = query(sql, new JobMapper(), id);
		return listJob.isEmpty() ? null : listJob.get(0);
	}

	@Override
	public Integer save(JobModel jobModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO job");
		sql.append(" (project_id, name, content, user_id, starteddate, endeddate, status_id, createdby, createddate)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
		return insert(sql.toString(), jobModel.getProjectId(), jobModel.getName(), jobModel.getContent(),
				jobModel.getUserId(), jobModel.getStartedDate(), jobModel.getEndedDate(), jobModel.getStatusId(),
				jobModel.getCreatedBy(), jobModel.getCreatedDate());
	}

	@Override
	public void update(JobModel jobModel) {
		StringBuilder sql = new StringBuilder("UPDATE job SET project_id=?, name=?,");
		sql.append(" content=?, user_id=?, starteddate=?,");
		sql.append(" endeddate=?, status_id=?, createdby=?, createddate=?, modifiedby=?, modifieddate=? WHERE id=?");
		this.update(sql.toString(), jobModel.getProjectId(), jobModel.getName(), jobModel.getContent(),
				jobModel.getUserId(), jobModel.getStartedDate(), jobModel.getEndedDate(), jobModel.getStatusId(),
				jobModel.getCreatedBy(), jobModel.getCreatedDate(), jobModel.getModifiedBy(),jobModel.getModifiedDate(), jobModel.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM job WHERE id=?";
		this.update(sql, id);
	}

}
