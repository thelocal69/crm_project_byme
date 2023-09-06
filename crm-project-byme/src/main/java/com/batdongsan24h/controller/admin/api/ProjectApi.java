package com.batdongsan24h.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.batdongsan24h.model.ProjectModel;
import com.batdongsan24h.model.UserModel;
import com.batdongsan24h.service.impl.IProjectService;
import com.batdongsan24h.utils.HttpUtil;
import com.batdongsan24h.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-project"})
public class ProjectApi extends HttpServlet{
	
	@Inject
	private IProjectService projectService;
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProjectModel addProject = HttpUtil.of(req.getReader()).toModel(ProjectModel.class);
		addProject.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		addProject = projectService.save(addProject);
		mapper.writeValue(resp.getOutputStream(), addProject);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProjectModel updateProject = HttpUtil.of(req.getReader()).toModel(ProjectModel.class);
		updateProject.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		updateProject = projectService.update(updateProject);
		mapper.writeValue(resp.getOutputStream(), updateProject);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProjectModel deleteProject = HttpUtil.of(req.getReader()).toModel(ProjectModel.class);
		this.projectService.deleteById(deleteProject.getId());
		mapper.writeValue(resp.getOutputStream(), "{}");
		
	}
}
