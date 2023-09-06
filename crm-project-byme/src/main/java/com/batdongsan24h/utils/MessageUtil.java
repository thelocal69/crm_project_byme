package com.batdongsan24h.utils;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	
	public static void showMessage(HttpServletRequest request) {
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
		if (request.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			if (message.equals("insert_success")) {
				messageResponse = resourceBundle.getString("insert_success");
				alert = "success";
			}else if (message.equals("update_success")) {
				messageResponse = resourceBundle.getString("update_success");
				alert = "success";
			}else if (message.equals("error_system")) {
				messageResponse = resourceBundle.getString("error_system");
				alert = "danger";
			}else if (message.equals("delete_success")) {
				messageResponse = resourceBundle.getString("delete_success");
				alert = "success";
			}else if (message.equals("email_password_invalid")) {
				messageResponse = resourceBundle.getString("email_password_invalid");
				alert = "danger";
			}else if (message.equals("login_first")) {
				messageResponse = resourceBundle.getString("login_first");
				alert = "danger";
			}
			request.setAttribute("messageResponse", messageResponse);
			request.setAttribute("alert", alert);
		}
	}
}
