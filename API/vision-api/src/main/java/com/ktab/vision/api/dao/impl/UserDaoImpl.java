package com.ktab.vision.api.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import com.ktab.vision.api.dao.UserDao;
import com.ktab.vision.api.dao.model.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@Override
	public User findByEmail(String username) {
		return findByParameter(username, "email");
	}

	@SuppressWarnings("unchecked")
	@Transactional
	private User findByParameter(String value, String parameter) {
		List<User> users = new ArrayList<User>();
		users = getSessionFactory().getCurrentSession().createQuery("from User where " + parameter + "=?").setParameter(0, value).list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
