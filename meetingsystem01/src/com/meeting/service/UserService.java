package com.meeting.service;

import com.meeting.dao.IUserDao;
import com.meeting.dao.UserDaoImpl;
import com.meeting.domain.TUser;

public class UserService implements IUserService {
	private IUserDao userDao;
	
	public UserService() {
		super();
		userDao=new UserDaoImpl();
	}

	@Override
	public boolean checkLogin(TUser user) {
		System.out.println("call UserService checkLogin method...");
		TUser u=userDao.getUser(user);
		if(u!=null){
			return true;
		}
		return false;
	}

}
