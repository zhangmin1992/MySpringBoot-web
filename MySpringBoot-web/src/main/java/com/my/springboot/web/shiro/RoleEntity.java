package com.my.springboot.web.shiro;

public class RoleEntity {

	 private Long id;
	 
	 private Long userId;
	 
	 private String role;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public RoleEntity(Long id, Long userId, String role) {
		super();
		this.id = id;
		this.userId = userId;
		this.role = role;
	}

}
