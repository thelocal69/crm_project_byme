package com.batdongsan24h.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.batdongsan24h.model.UserModel;
import com.batdongsan24h.utils.SessionUtil;

public class AuthorizationFillter implements Filter{
	
	@SuppressWarnings("unused")
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req =  (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURI();
		if (url.startsWith(req.getContextPath()+"/admin")) {
			UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
			if (userModel != null) {
				if (userModel.getRoleId() == 1) {
					chain.doFilter(request, response);
				}else if (userModel.getRoleId() == 2) {
					resp.sendRedirect(req.getContextPath()+"/403-error");
				}
			}else {
				resp.sendRedirect(req.getContextPath()+"/login?action=login&message=login_first&alert=danger");
			}
		}else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void destroy() {
		
	}
	
}
