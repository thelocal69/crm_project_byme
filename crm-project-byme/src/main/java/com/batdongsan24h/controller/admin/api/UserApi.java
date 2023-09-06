package com.batdongsan24h.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.batdongsan24h.model.UserModel;
import com.batdongsan24h.service.impl.IUserService;
import com.batdongsan24h.utils.HttpUtil;
import com.batdongsan24h.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-member"})
public class UserApi extends HttpServlet{
	
	@Inject
	private IUserService userService;

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		userModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		userModel = userService.save(userModel);
		mapper.writeValue(resp.getOutputStream(), userModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel updateUser = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		updateUser.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		updateUser = userService.update(updateUser);
		mapper.writeValue(resp.getOutputStream(), updateUser);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserModel deleteUser = HttpUtil.of(req.getReader()).toModel(UserModel.class);
		this.userService.deleteById(deleteUser.getId());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

}
