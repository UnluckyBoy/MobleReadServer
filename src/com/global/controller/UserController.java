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

import com.alibaba.fastjson.JSON;
import com.global.pojo.Record;
import com.global.pojo.User;
import com.global.service.BackService;
import com.global.service.BackServiceImpl;

@Controller()
@RequestMapping("/UserController")
public class UserController {
	
	//private BackServiceImpl user;
	@Autowired
	private BackService backService;
	private User user;
	
	
	//�û�ע��
	@RequestMapping("/register")
	@ResponseBody
	public Map Register(@RequestParam("account") String account,@RequestParam("password") String password,
			HttpServletRequest request,Model model){
		Map<String,String> regisMap=new HashMap<String,String>();
		Map<String,String> result_map=new HashMap<String, String>();
		regisMap.put("account", account);
		regisMap.put("password", password);
		//regisMap.put("sex", sex);
		String response="true";
		if(backService.login(regisMap)!=null){
			response="false";
			result_map.put("result", response);
			return result_map;
		}else{
			backService.register(regisMap);
			result_map.put("result", response);
			return result_map;
		}
	}
	//�û���¼
	@RequestMapping("/login")
	@ResponseBody
	public Map Login(@RequestParam("account") String account,@RequestParam("password") String password,
			HttpServletRequest request,Model model){
		
		Map<String,String> user_map=new HashMap<String, String>();
		Map<String,String> result_map=new HashMap<String, String>();
		//map.put("account",request.getParameter("account"));
		user_map.put("account",account);
		user_map.put("password",password);
		System.out.println("map:"+user_map);
		String response="true";
		//String response="false";
		if(backService.login(user_map).equals(null)){
			System.out.println("��¼ʧ��"+user_map);
			response="false";
			result_map.put("result", response);
			return result_map;
		}else{
			result_map.put("result", response);
			return result_map;
		}
		//return result_map;
	}
	
	//��ȡ�û���Ϣ
	@RequestMapping("/userInfo")
	@ResponseBody
	public Map GetUser(@RequestParam("account") String account,HttpServletRequest request,Model model){
		List<Object> userList=new ArrayList<Object>();
		Map<String,String> userMap=new HashMap<String, String>();
		Map ResultMap=new HashMap();
		user=backService.getUser(account);
		userMap.put("name", user.getUsername());
		userMap.put("account", user.getAccount());
		userMap.put("pwd", user.getPassword());
		userMap.put("sex", user.getSex());
		userMap.put("head", user.getHeadpath());
		userList.add(userMap);
		ResultMap.put("user", userList);
		return ResultMap;
	}
	
	//�޸��û���Ϣ
	@RequestMapping("/upUser")
	@ResponseBody
	public Map ChangInfo(){
		
		return null;
	}
	
	//��ȡ�Ķ���¼
	@RequestMapping("/record")
	@ResponseBody
	public Map UserRecord(@RequestParam("account") String account,HttpServletRequest request,Model model){
		List<Record> RecordList=new ArrayList<Record>();
		List<Object> ResultList=new ArrayList<Object>();
		//List<Object> Result=new ArrayList<Object>();
		Map RecordMap=new HashMap();
		RecordList=backService.getRecord(account);
		//System.out.println("�Ķ���¼����:"+RecordList.toString());
		for(int i=0;i<RecordList.size();i++){
			//System.out.println("�Ķ���¼��������:"+RecordList.get(i).getBook_name());
			ResultList.add(backService.nameSearch(RecordList.get(i).getBook_name()));
			//System.out.println("�Ķ���¼�鼮����:"+ResultList.toString());
			//Result.add(ResultList);
		}
		System.out.println("�Ķ���¼�鼮����:"+ResultList.toString());
		RecordMap.put("Record",ResultList);
		return RecordMap;
	}
	
	//��ȡ��ʷ�Ķ���Ȥ
	@RequestMapping("/readhistory")
	@ResponseBody
	public Map GetReadHistory(@RequestParam("account") String account,HttpServletRequest request,Model model){
		List<Object> HistoryList=new ArrayList<Object>();
		Map HistoryMap=new HashMap();
		String ReadKey=backService.getRecordType(account);
		//HistoryList=backService.getRecordType(account);
		//System.out.println("�û���ʷ���ͣ�"+ReadKey);
		if(ReadKey!=null){
			HistoryList=backService.Historytype(ReadKey);
			HistoryMap.put("Book", HistoryList);
			//System.out.println("��ͬ�û���ʷ�����鼮��"+HistoryList.toString());
		}
		return HistoryMap;
	}
	
	//�û���������ϲ�ѯ
	@RequestMapping("/isRecord")
	@ResponseBody
	public Map IsRecord(@RequestParam("account") String account,@RequestParam("name") String name,
			HttpServletRequest request,Model model){
		Map<String,String> RecordMap=new HashMap<String,String>();
		Map<String,String> IsRecordMap=new HashMap<String,String>();
		String result="false";
		try {
			String nameKey=new String(name.getBytes("iso-8859-1"), "utf-8");
			RecordMap.put("account",account);
			RecordMap.put("name",nameKey);
			//System.out.println("��ѯ���:"+backService.IsRead(RecordMap));
			if(backService.IsRead(RecordMap)!=null){
			//if(backService.IsRead(RecordMap)){
				result="true";
				IsRecordMap.put("result", result);
				//return IsRecordMap;
			}else{
				IsRecordMap.put("result", result);
				//return IsRecordMap;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if(backService.IsRead(account, name));
		return IsRecordMap;
	}
	
	//��ѯ�Ƿ��״��Ķ�
	@RequestMapping("/isFirst")
	@ResponseBody
	public Map IsFirst(@RequestParam("account") String account,HttpServletRequest request,Model model){
		
		Map<String,String> ResponseMap=new HashMap<String,String>();
		String response="false";
		if(backService.IsFirstRead(account)==null){
			response="true";
			ResponseMap.put("result", response);
		}else{
			ResponseMap.put("result", response);
		}
		return ResponseMap;
	}
}
