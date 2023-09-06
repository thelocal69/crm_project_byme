package com.batdongsan24h.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.batdongsan24h.constant.SystemConstant;
import com.batdongsan24h.model.ProjectModel;
import com.batdongsan24h.service.impl.IProjectService;
import com.batdongsan24h.utils.FormUtil;
import com.batdongsan24h.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-project"})
public class ProjectController extends HttpServlet{
	
	@Inject
	private IProjectService projectService;

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "";
		ProjectModel model = FormUtil.toModel(ProjectModel.class, req);
		if (model.getType().equals(SystemConstant.ADDNEW)) {
			if (model.getId() != null) {
				model = projectService.findOne(model.getId());
			}
			view = "/views/admin/project/project-add.jsp";
		}else if (model.getType().equals(SystemConstant.LIST)) {
			req.setAttribute("listProject", projectService.findAll());
			view = "/views/admin/project/project-table.jsp";
		}else if (model.getType().equals(SystemConstant.DETAIL)) {
			view = "/views/admin/project/project-detail.jsp";
		}
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
