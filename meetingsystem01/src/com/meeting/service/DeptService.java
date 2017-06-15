package com.meeting.service;

import java.util.List;

import com.google.gson.Gson;
import com.meeting.dao.DeptDao;
import com.meeting.dao.IDeptDao;
import com.meeting.domain.TDept;
import com.meeting.domain.TUser;
import com.meeting.util.TreeNode;

public class DeptService implements IDeptService {
	private IDeptDao deptDao;
	
	public DeptService() {
		super();
		deptDao=new DeptDao();
	}

	@Override
	public String deptListJson() {
		List<TDept> list=deptDao.getDeptList();
		//�б�תJSON��
		TreeNode root = new TreeNode("0", "0", "���ڵ�", "������˾-��ע");
		TreeNode node = null;
		for (TDept tDept : list) {
			node = new TreeNode(tDept.getId(), tDept.getPid(), tDept.getName(), "");
			root.add(node);
		} 
		Gson gson=new Gson();
		String json=gson.toJson(root.getChildren());
		System.out.println(json);
		return json;
	}

	@Override
	public String getUsersByDeptId(String dept_id) {
		List<TUser> userlist=deptDao.getUsersByDeptId(dept_id);
		Gson gson=new Gson();
		String json=gson.toJson(userlist);
		return json;
	}

}
