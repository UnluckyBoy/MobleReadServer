package com.global.pojo;

public class Book {

	private int Id;
	private String name;
	private String pic;
	private String writer;
	private String type;
	private int hot;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public Book() {
		super();
	}
	public Book(String name, String pic, String writer, String type, int hot) {
		super();
		this.name = name;
		this.pic = pic;
		this.writer = writer;
		this.type = type;
		this.hot = hot;
	}
	public Book(int id, String name, String pic, String writer, String type,
			int hot) {
		super();
		Id = id;
		this.name = name;
		this.pic = pic;
		this.writer = writer;
		this.type = type;
		this.hot = hot;
	}
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", name=" + name + ", pic=" + pic
				+ ", writer=" + writer + ", type=" + type + ", hot=" + hot
				+ "]";
	}
	
}
