package com.global.service;

import java.util.*;

import com.global.pojo.Book;
import com.global.pojo.BookFile;
import com.global.pojo.Record;
import com.global.pojo.User;

public interface BackService {
	/*
	 * Mapper接口
	 */
	public void register(Map<String,String> map);
	public User login(Map<String,String> map);
	public User getUser(String account);
	public List getAllBook();
	public List searchBook(String Key);
	public Book nameSearch(String Key);//书名检索（特殊用处）
	public List typeSeach(String Type);
	public BookFile getFile(String KeyId);
	public List getHot();//首页推荐
	public List<Record> getRecord(String account);//获取阅读记录
	public int upHot(Book book);//更新阅读量
	public String getRecordType(String account);//获取阅读历史书籍类型
	public List Historytype(String Type);//获取阅读历史想同类型书籍
	public Record IsRead(Map<String,String> map);//用户号书名组合查询
	public Record IsFirstRead(String account);//查询是否首次阅读
	public void upHistory(Map<String,String> map);//添加用户阅读记录
}
