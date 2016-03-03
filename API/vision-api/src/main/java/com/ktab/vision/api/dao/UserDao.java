package com.ktab.vision.api.dao;

import javax.transaction.Transactional;

import com.ktab.vision.api.dao.model.User;

public interface UserDao {
	@Transactional
	User findByEmail(String username);
	
}
