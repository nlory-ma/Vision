package com.ktab.vision.api.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.ktab.vision.api.dao.model.User;

public class SessionUtil {

	public static void addLoginUserToSession(HttpServletRequest request, User user) {
		if (request != null && user != null) {
			request.setAttribute("8918loginUser", user);
		}
	}

	public static User getLoginUserFromSession(HttpServletRequest request) {
		if (request != null) {
			Object attribute = request.getAttribute("8918loginUser");
			if (attribute instanceof User) {
				return (User) attribute;
			}
			try {
				request.getRequestDispatcher("/403").forward(request, null);
			} catch (ServletException | IOException e) {
			}
		}
		return null;
	}
}
