package com.global.pojo;

public class BookFile {

	private int book_Id;
	private String book_name;
	private String book_file;
	public int getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_file() {
		return book_file;
	}
	public void setBook_file(String book_file) {
		this.book_file = book_file;
	}
	public BookFile() {
		super();
	}
	public BookFile(String book_name, String book_file) {
		super();
		this.book_name = book_name;
		this.book_file = book_file;
	}
	public BookFile(int book_Id, String book_name, String book_file) {
		super();
		this.book_Id = book_Id;
		this.book_name = book_name;
		this.book_file = book_file;
	}
	@Override
	public String toString() {
		return "File [book_Id=" + book_Id + ", book_name=" + book_name
				+ ", book_file=" + book_file + "]";
	}
}
