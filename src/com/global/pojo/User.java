package com.global.pojo;

public class User {

	private int id;
	private String user_name;
	private String user_account;
	private String user_pwd;
	private String user_sex;
	private String user_head;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return user_name;
	}
	public void setUsername(String username) {
		this.user_name = username;
	}
	public String getAccount() {
		return user_account;
	}
	public void setAccount(String account) {
		this.user_account = account;
	}
	public String getPassword() {
		return user_pwd;
	}
	public void setPassword(String password) {
		this.user_pwd = password;
	}
	public String getSex() {
		return user_sex;
	}
	public void setSex(String sex) {
		this.user_sex = sex;
	}
	public String getHeadpath() {
		return user_head;
	}
	public void setHeadpath(String headpath) {
		this.user_head = headpath;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name
				+ ", user_account=" + user_account + ", user_pwd=" + user_pwd
				+ ", user_sex=" + user_sex + ", user_head=" + user_head + "]";
	}
	
	public User() {
		super();
	}
	public User(int id, String user_name, String user_account, String user_pwd,
			String user_sex, String user_head) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_account = user_account;
		this.user_pwd = user_pwd;
		this.user_sex = user_sex;
		this.user_head = user_head;
	}
	public User(String user_name, String user_account, String user_pwd,
			String user_sex, String user_head) {
		super();
		this.user_name = user_name;
		this.user_account = user_account;
		this.user_pwd = user_pwd;
		this.user_sex = user_sex;
		this.user_head = user_head;
	}
}
