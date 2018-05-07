package com.crm.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	private Long id;

	private String name;

	private String password;

	private String trueName;

	private String email;

	private String phone;

	private String roleName;

	private Boolean admin;

	private List<Role> roles; // 员工对应的角色

	private static final long serialVersionUID = 1L;

	public User(Long id, String name, String password, String trueName, String email, String phone,
			String roleName) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.trueName = trueName;
		this.email = email;
		this.phone = phone;
		this.roleName = roleName;
	}

	public User(Long id, String name, String password, String trueName, String email, String phone, String roleName,
			Boolean admin) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.trueName = trueName;
		this.email = email;
		this.phone = phone;
		this.roleName = roleName;
		this.admin = admin;
	}



	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName == null ? null : trueName.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", password=").append(password);
		sb.append(", trueName=").append(trueName);
		sb.append(", email=").append(email);
		sb.append(", phone=").append(phone);
		sb.append(", roleName=").append(roleName);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}