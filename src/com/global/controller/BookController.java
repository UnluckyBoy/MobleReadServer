package com.global.controller;

import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.global.otherController.BookFileModel;
import com.global.pojo.Book;
import com.global.pojo.BookFile;
import com.global.service.BackService;


@Controller()
@RequestMapping("/BookController")
public class BookController {

	@Autowired
	private BackService backService;
	private Book book;
	private BookFileModel bookModel;
	private BookFile bookFile;
	
	
	//加载全部书籍
	@RequestMapping("/loadAll")
	@ResponseBody
	public Map GetAll(HttpServletRequest request,Model model){
		
		List<Object> bookList=new ArrayList<Object>();
		Map bookMap=new HashMap();
		bookList=backService.getAllBook();
		bookMap.put("BOOK", bookList);
		return bookMap;
	}
	
	//书名、作者搜索
	@RequestMapping("/searchBook")
	@ResponseBody
	public Map SearchBook(@RequestParam("Key") String Key,
			HttpServletRequest request,Model model){
		List<Object> searchList=new ArrayList<Object>();
		Map bookMap=new HashMap();
		try {
			String StringtoKey=new String(Key.getBytes("iso-8859-1"), "utf-8");//中文字符转换
			searchList=backService.searchBook(StringtoKey);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bookMap.put("BOOK", searchList);
		return bookMap;
	}
	
	//类型搜索
	@RequestMapping("/typeSearch")
	@ResponseBody
	public Map TypeSearch(@RequestParam("Type") String Type,
			HttpServletRequest request,Model model){
		List<Object> TypeSearchList=new ArrayList<Object>();
		Map bookMap=new HashMap();
		try {
			String StringtoType=new String(Type.getBytes("iso-8859-1"), "utf-8");//中文字符转换
			TypeSearchList=backService.typeSeach(StringtoType);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bookMap.put("BOOK", TypeSearchList);
		return bookMap;
	}
	
	//加载书籍内容
	@RequestMapping("/loadFile")
	@ResponseBody
	public Map getFile(@RequestParam("BookKey") String BookKey,
			HttpServletRequest request,Model model){
		List<Object> FileList=new ArrayList<Object>();
		Map<String,String> FileMap=new HashMap<String,String>();
		Map bookMap=new HashMap();
		try {
			String KeyId=new String(BookKey.getBytes("iso-8859-1"), "utf-8");//中文字符转换
			bookFile=backService.getFile(KeyId);
			FileMap.put("book_Id", String.valueOf(bookFile.getBook_Id()));
			FileMap.put("book_name", bookFile.getBook_name());
			FileMap.put("book_file", bookModel.ReadFile(bookFile.getBook_file()));
			FileList.add(FileMap);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bookMap.put("FILE", FileList);
		return bookMap;
	}
	
	//首页推荐
	@RequestMapping("/hotest")
	@ResponseBody
	public Map Recommende(HttpServletRequest request,Model model){
		List<Object> RecommendeList=new ArrayList<Object>();
		Map RecommendeMap=new HashMap();
		RecommendeList=backService.getHot();
		RecommendeMap.put("Book", RecommendeList);
		return RecommendeMap;
	}
	
	//阅读量实时更新
	@RequestMapping("/userRead")
	@ResponseBody
	public Map UpdateHot(@RequestParam("name") String Name,
			HttpServletRequest request,Model model){
		Map UphotMap=new HashMap();
		try {
			String NameKey= new String(Name.getBytes("iso-8859-1"), "utf-8");
			book=backService.nameSearch(NameKey);
			System.out.println("阅读量更新前book:"+book.toString());
			int NewHot=book.getHot();
			NewHot=NewHot+1;
			Book Newbook=new Book(book.getId(),book.getName(),book.getPic(),book.getWriter(),book.getType(),NewHot);
			System.out.println("阅读量更新后book:"+Newbook.toString());
			if(backService.upHot(Newbook)>0){
				UphotMap.put("result", "true");
			}else{
				UphotMap.put("result", "false");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UphotMap;
	}
	
	//添加用户阅读记录
	@RequestMapping("/upHistory")
	@ResponseBody
	public Map UpHistory(@RequestParam("account") String account,@RequestParam("name") String name,
			HttpServletRequest request,Model model) throws UnsupportedEncodingException{
		Map<String,String> RequestMap=new HashMap<String,String>();
		Map<String,String> UpHistoryMap=new HashMap<String,String>();
		String nameKey=new String(name.getBytes("iso-8859-1"),"utf-8");
		RequestMap.put("account", account);
		RequestMap.put("name", nameKey);
		String response="true";
		if(backService.IsRead(RequestMap)==null){
			System.out.println("用户"+account+"尚未阅读："+nameKey);
			backService.upHistory(RequestMap);
			UpHistoryMap.put("result", response);
		}else{
			response="false";
			UpHistoryMap.put("result", response);
		}
		return UpHistoryMap;
	}
}
