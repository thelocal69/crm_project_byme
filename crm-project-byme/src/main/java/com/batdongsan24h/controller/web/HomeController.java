package com.batdongsan24h.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.batdongsan24h.model.UserModel;
import com.batdongsan24h.service.impl.IUserService;
import com.batdongsan24h.utils.FormUtil;
import com.batdongsan24h.utils.MessageUtil;
import com.batdongsan24h.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/login", "/logout" })
public class HomeController extends HttpServlet {

	@Inject
	private IUserService userService;
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String home = "/views/web/home.jsp";
		String login = "/views/login.jsp";
		String action = req.getParameter("action");
		MessageUtil.showMessage(req);
		if (action != null && action.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher(login);
			rd.forward(req, resp);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath() + "/trang-chu");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher(home);
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, req);
			model = userService.findEmailAndPassword(model.getEmail(), model.getPass());
			if (model != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", model);
				if (model.getRoleId() == 1) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				} else if (model.getRoleId() == 2) {
					resp.sendRedirect(req.getContextPath() + "/trang-chu");
				}
			} else {
				resp.sendRedirect(
						req.getContextPath() + "/login?action=login&message=email_password_invalid&alert=danger");
			}
		}
	}
}
