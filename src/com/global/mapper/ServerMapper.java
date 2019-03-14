package com.global.mapper;

import java.util.*;

import com.global.pojo.Book;
import com.global.pojo.BookFile;
import com.global.pojo.Record;
import com.global.pojo.User;

public interface ServerMapper {
	/*
	 * SQL语句接口
	 */
	public void register(Map<String,String> map);//注册
	public User login(Map<String,String> map);//登录
	public User getUser(String account);//获取用户信息
	public List getAllBook();//加载全部书籍
	public List searchBook(String Key);//书名、作者检索
	public Book nameSearch(String Key);//书名检索（特殊用处）
	public List typeSeach(String Type);//类型检索
	public BookFile getFile(String KeyId);//获取书籍内容
	public List getHot();//首页推荐
	public List<Record> getRecord(String account);//获取阅读记录
	public int upHot(Book book);//更新阅读量
	public String getRecordType(String account);//获取阅读历史书籍类型
	public List Historytype(String Type);//获取阅读历史想同类型书籍
	public Record IsRead(Map<String,String> map);//用户号书名组合查询
	public Record IsFirstRead(String account);//查询是否首次阅读
	public void upHistory(Map<String,String> map);//添加用户阅读记录
}
