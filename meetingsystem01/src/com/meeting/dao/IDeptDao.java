package com.meeting.dao;

import java.util.List;

import com.meeting.domain.TDept;
import com.meeting.domain.TUser;

public interface IDeptDao {
	
	public List<TDept> getDeptList();

	public List<TUser> getUsersByDeptId(String dept_id);

}
