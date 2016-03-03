package com.ktab.vision.api.session;

import com.ktab.vision.api.dao.model.User;

public class UserContext {

	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
