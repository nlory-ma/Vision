package com.ktab.vision.api.dao.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ktab.vision.api.controlers.PreRequisitesController;
import com.ktab.vision.api.dao.PreRequisitesDao;
import com.ktab.vision.api.dao.model.Customer;
import com.ktab.vision.api.dao.model.OrderStatus;
import com.ktab.vision.api.dao.model.Role;
import com.ktab.vision.api.dao.model.Team;
import com.ktab.vision.api.dao.model.User;

public class PreRequisitesDaoImpl implements PreRequisitesDao {

	@Autowired
	SessionFactory sessionFactory;
	private Role sAdmin;
	private Role admin;
	private Role operator;
	private Role clientAdmin;
	private Role clientUser;
	private Role endUser;
	private User user1;
	private User user2;

	private static final Logger logger = LoggerFactory.getLogger(PreRequisitesController.class);

	@Override
	@Transactional
	public void insertRerequisites() {
		insertRoles();
		insertUsers();
		insertCustomer();
		insertTeam();
	}

	@Override
	@Transactional
	public void retreveRerequisites() {
		Team team = (Team) sessionFactory.getCurrentSession().get(Team.class, new Long(1).longValue());
		System.out.println(team.getName());
		Set<Team> children = team.getChildren();
		logger.info("Count : " + children.size());
		for (Team team2 : children) {
			logger.info(team2.getName());
		}
	}

	public void insertStatus() {
		sessionFactory.getCurrentSession().saveOrUpdate(new OrderStatus(10, "Un-Scheduled", "This order is not Scheduled", 1));
		sessionFactory.getCurrentSession().saveOrUpdate(new OrderStatus(20, "Scheduled", "Order Scheduled", 2));
		sessionFactory.getCurrentSession().saveOrUpdate(new OrderStatus(30, "Assigned", "Order Assigned to Field Executive", 3));
		sessionFactory.getCurrentSession().saveOrUpdate(new OrderStatus(40, "In-Transit", "Order is In Transit", 4));
		sessionFactory.getCurrentSession().saveOrUpdate(new OrderStatus(50, "Returned to Source", "Returned to Partner's Hub", 5));
		sessionFactory.getCurrentSession().saveOrUpdate(new OrderStatus(60, "Returned to Hub", "Order kept in Our Hub", 6));
		sessionFactory.getCurrentSession().saveOrUpdate(new OrderStatus(70, "Delivered", "Order Delivered", 7));
		sessionFactory.getCurrentSession().saveOrUpdate(new OrderStatus(70, "Rejected", "Order Rejected", 8));
		sessionFactory.getCurrentSession().saveOrUpdate(new OrderStatus(70, "Cancelled", "Order Cancelled", 9));
	}

	public void insertTeam() {
		Team root = new Team("root", user1);
		Team team = new Team("sub1", user1);
		root.addChild(team);
		Team team2 = new Team("sub2", user2);
		root.addChild(team2);
		Team team3 = new Team("sub3", user2);
		root.addChild(team3);
		sessionFactory.getCurrentSession().saveOrUpdate(team);
		sessionFactory.getCurrentSession().saveOrUpdate(team2);
		sessionFactory.getCurrentSession().saveOrUpdate(team3);
		sessionFactory.getCurrentSession().saveOrUpdate(root);
	}

	public void insertCustomer() {
		Customer customer = new Customer("Testing", "1234567890", "test@example.com", null, null);
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@SuppressWarnings("serial")
	private void insertUsers() {
		user1 = new User("test@example.com", "$2a$10$TjCYzg5VynGK1GG9dmMtMu7bPG7rZzdyK0zZGZHlMTK.UzM4G.cGO", "Test", "User", true);
		user1.setRoles(new HashSet<Role>() {
			{
				add(sAdmin);
			}
		});
		sessionFactory.getCurrentSession().saveOrUpdate(user1);
	}

	private void insertRoles() {
		// Super Administrator
		sAdmin = new Role(10, "ROLE_SUPER_ADMIN", "Super Administrator");
		sessionFactory.getCurrentSession().saveOrUpdate(sAdmin);
		// Administrator
		admin = new Role(20, "ROLE_ADMINISTRATOR", "Administrator");
		sessionFactory.getCurrentSession().saveOrUpdate(admin);
		// Operator
		operator = new Role(30, "ROLE_OPERATOR", "Operator");
		sessionFactory.getCurrentSession().saveOrUpdate(operator);
		// Client Administrator
		clientAdmin = new Role(40, "ROLE_CLIENT_ADMIN", "Client Administrator");
		sessionFactory.getCurrentSession().saveOrUpdate(clientAdmin);
		// Client User
		clientUser = new Role(50, "ROLE_CLIENT_USER", "Client User");
		sessionFactory.getCurrentSession().saveOrUpdate(clientUser);
		// Customer
		endUser = new Role(60, "ROLE_END_USER", "Customer");
		sessionFactory.getCurrentSession().saveOrUpdate(endUser);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
