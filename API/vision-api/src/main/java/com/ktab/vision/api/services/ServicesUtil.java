package com.ktab.vision.api.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.ktab.vision.api.VisionConstants;
import com.ktab.vision.api.dao.UserDao;
import com.ktab.vision.api.dao.model.User;

public class ServicesUtil {
	UserDao userDao;

	public User getAuthenticatedUser(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.isAuthenticated()) {
			if (request.getSession().getAttribute(VisionConstants.USER_CONTEXT) != null) {
				Object attribute = request.getSession().getAttribute(VisionConstants.USER_CONTEXT);
				if (attribute instanceof User) {
					return (User) attribute;
				}
			} else if (!(auth instanceof AnonymousAuthenticationToken)) {
				UserDetails userDetail = (UserDetails) auth.getPrincipal();
				String userName = userDetail.getUsername();
				return userDao.findByEmail(userName);
			}
		}
		return null;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
