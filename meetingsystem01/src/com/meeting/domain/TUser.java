package com.meeting.domain;

public class TUser {
	private int id;
	private String login_name;
	private String login_password;
	private String phone;
	
	
	public TUser() {
		super();
	}
	public TUser(int id, String login_name, String login_password, String phone) {
		super();
		this.id = id;
		this.login_name = login_name;
		this.login_password = login_password;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_password() {
		return login_password;
	}
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
