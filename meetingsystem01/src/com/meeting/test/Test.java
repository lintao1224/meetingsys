package com.meeting.test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.meeting.domain.TUser;

public class Test {

	public static void main(String[] args) {
		
		Gson gson=new Gson();
		TUser user1=new TUser(1, "zhangsan", "111", "110");
		TUser user2=new TUser(2, "lisi", "444", "120");
		
		
		String json1=gson.toJson(user1);
		System.out.println(json1);
		
		List<TUser> list=new ArrayList<TUser>();
		list.add(user1);
		list.add(user2);
		String jsonlist=gson.toJson(list);
		System.out.println("¥Ú”°List Json");
		System.out.println(jsonlist);
	}

}
