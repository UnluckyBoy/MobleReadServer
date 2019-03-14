package com.global.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.mapper.ServerMapper;
import com.global.pojo.Book;
import com.global.pojo.BookFile;
import com.global.pojo.Record;
import com.global.pojo.User;

@Service
@Transactional
public class BackServiceImpl implements BackService{
	
	@Autowired
	private ServerMapper serverMapper;

	@Override
	public User login(Map<String, String> map) {
		// TODO Auto-generated method stub
		return serverMapper.login(map);
	}

	@Override
	public User getUser(String account) {
		// TODO Auto-generated method stub
		return serverMapper.getUser(account);
	}

	@Override
	public List getAllBook() {
		// TODO Auto-generated method stub
		return serverMapper.getAllBook();
	}

	@Override
	public void register(Map<String, String> map) {
		// TODO Auto-generated method stub
		serverMapper.register(map);
	}

	@Override
	public List searchBook(String Key) {
		// TODO Auto-generated method stub
		return serverMapper.searchBook(Key);
	}

	@Override
	public List typeSeach(String Type) {
		// TODO Auto-generated method stub
		return serverMapper.typeSeach(Type);
	}

	@Override
	public BookFile getFile(String KeyId) {
		// TODO Auto-generated method stub
		return serverMapper.getFile(KeyId);
	}

	@Override
	public List getHot() {
		// TODO Auto-generated method stub
		return serverMapper.getHot();
	}

	@Override
	public List<Record> getRecord(String account) {
		// TODO Auto-generated method stub
		return serverMapper.getRecord(account);
	}

	@Override
	public int upHot(Book book) {
		// TODO Auto-generated method stub
		return serverMapper.upHot(book);
	}

	@Override
	public Book nameSearch(String Key) {
		// TODO Auto-generated method stub
		return serverMapper.nameSearch(Key);
	}

	@Override
	public String getRecordType(String account) {
		// TODO Auto-generated method stub
		return serverMapper.getRecordType(account);
	}

	@Override
	public List Historytype(String Type) {
		// TODO Auto-generated method stub
		return serverMapper.Historytype(Type);
	}

	@Override
	public Record IsRead(Map<String,String> map) {
		// TODO Auto-generated method stub
		return serverMapper.IsRead(map);
	}

	@Override
	public Record IsFirstRead(String account) {
		// TODO Auto-generated method stub
		return serverMapper.IsFirstRead(account);
	}

	@Override
	public void upHistory(Map<String, String> map) {
		// TODO Auto-generated method stub
		serverMapper.upHistory(map);
	}
}
