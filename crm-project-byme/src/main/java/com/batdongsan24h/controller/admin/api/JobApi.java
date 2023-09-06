package com.batdongsan24h.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.batdongsan24h.model.JobModel;
import com.batdongsan24h.model.UserModel;
import com.batdongsan24h.service.impl.IJobService;
import com.batdongsan24h.utils.HttpUtil;
import com.batdongsan24h.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-job"})
public class JobApi extends HttpServlet{
	
	@Inject
	private IJobService jobService;

	private static final long serialVersionUID = 1L;

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			JobModel addJob = HttpUtil.of(req.getReader()).toModel(JobModel.class);
			addJob.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
			addJob = jobService.save(addJob);
			mapper.writeValue(resp.getOutputStream(), addJob);
		}
		
		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			JobModel updateJob = HttpUtil.of(req.getReader()).toModel(JobModel.class);
			updateJob.setModifiedBy(((UserModel)SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
			updateJob = jobService.update(updateJob);
			mapper.writeValue(resp.getOutputStream(), updateJob);
		}
		
		@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			JobModel deleteJob = HttpUtil.of(req.getReader()).toModel(JobModel.class);
			this.jobService.deleteById(deleteJob.getId());
			mapper.writeValue(resp.getOutputStream(), "{}");
		}
}
