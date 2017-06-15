package com.meeting.service;

import com.meeting.domain.TUser;

public interface IUserService {
	/**
	 * 用户登录
	 * @param user 用户参数
	 * @return  true-登录成功，false-登录失败
	 */
	public boolean checkLogin(TUser user);

}
