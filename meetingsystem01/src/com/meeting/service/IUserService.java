package com.meeting.service;

import com.meeting.domain.TUser;

public interface IUserService {
	/**
	 * �û���¼
	 * @param user �û�����
	 * @return  true-��¼�ɹ���false-��¼ʧ��
	 */
	public boolean checkLogin(TUser user);

}
