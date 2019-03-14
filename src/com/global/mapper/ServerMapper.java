package com.global.mapper;

import java.util.*;

import com.global.pojo.Book;
import com.global.pojo.BookFile;
import com.global.pojo.Record;
import com.global.pojo.User;

public interface ServerMapper {
	/*
	 * SQL���ӿ�
	 */
	public void register(Map<String,String> map);//ע��
	public User login(Map<String,String> map);//��¼
	public User getUser(String account);//��ȡ�û���Ϣ
	public List getAllBook();//����ȫ���鼮
	public List searchBook(String Key);//���������߼���
	public Book nameSearch(String Key);//���������������ô���
	public List typeSeach(String Type);//���ͼ���
	public BookFile getFile(String KeyId);//��ȡ�鼮����
	public List getHot();//��ҳ�Ƽ�
	public List<Record> getRecord(String account);//��ȡ�Ķ���¼
	public int upHot(Book book);//�����Ķ���
	public String getRecordType(String account);//��ȡ�Ķ���ʷ�鼮����
	public List Historytype(String Type);//��ȡ�Ķ���ʷ��ͬ�����鼮
	public Record IsRead(Map<String,String> map);//�û���������ϲ�ѯ
	public Record IsFirstRead(String account);//��ѯ�Ƿ��״��Ķ�
	public void upHistory(Map<String,String> map);//����û��Ķ���¼
}
