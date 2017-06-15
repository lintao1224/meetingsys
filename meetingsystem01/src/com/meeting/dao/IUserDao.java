package com.meeting.dao;

import com.meeting.domain.TUser;

public interface IUserDao {
	
	public TUser getUser(TUser user);
	
	public void addUser(TUser user);

}
