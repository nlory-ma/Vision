package com.ktab.vision.api.dao.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Role {
	@Id
	private int roleId;
	private String roleName;
	private String description;
	@OneToMany(mappedBy = "roles")
	@NotFound(action = NotFoundAction.IGNORE)
	private List<User> users;

	public Role() {
	}

	public Role(int roleID, String roleName, String description) {
		super();
		this.roleId = roleID;
		this.roleName = roleName;
		this.description = description;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
