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
import com.batdongsan24h.model.JobModel;
import com.batdongsan24h.service.impl.IJobService;
import com.batdongsan24h.service.impl.IProjectService;
import com.batdongsan24h.service.impl.IStatusService;
import com.batdongsan24h.service.impl.IUserService;
import com.batdongsan24h.utils.FormUtil;
import com.batdongsan24h.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-job"})
public class JobController extends HttpServlet{
	
	@Inject
	private IProjectService projectService;
	
	@Inject
	private IUserService userService;
	
	@Inject
	private IStatusService statusService;
	
	@Inject
	private IJobService jobService;

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "";
		JobModel model = FormUtil.toModel(JobModel.class, req);
		if (model.getType().equals(SystemConstant.ADDNEW)) {
			if (model.getId() != null) {
				model = jobService.findOne(model.getId());
			}
			req.setAttribute("projects",projectService.findAll());
			req.setAttribute("users", userService.findAll());
			req.setAttribute("statuss", statusService.findAll());
			view = "/views/admin/job/job-add.jsp";
		}else if (model.getType().equals(SystemConstant.LIST)) {
			req.setAttribute("listJob", jobService.findAll());
			view = "/views/admin/job/job-table.jsp";
		}else if (model.getType().equals(SystemConstant.DETAIL)) {
			view = "/views/admin/job/job-detail.jsp";
		}else if (model.getType().equals(SystemConstant.PROFILE)) {
			view = "views/admin/member/profile/profile-table.jsp";
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
