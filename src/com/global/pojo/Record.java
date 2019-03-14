package com.global.pojo;


/*
 * ‘› ±Œﬁ”√
 */
public class Record {

	@Override
	public String toString() {
		return "Record [id=" + id + ", user_account=" + user_account
				+ ", book_name=" + book_name + "]";
	}
	private int id;
	private String user_account;
	private String book_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Record() {
		super();
	}
	public Record(String user_account, String book_name) {
		super();
		this.user_account = user_account;
		this.book_name = book_name;
	}
	public Record(int id, String user_account, String book_name) {
		super();
		this.id = id;
		this.user_account = user_account;
		this.book_name = book_name;
	}
	
}
