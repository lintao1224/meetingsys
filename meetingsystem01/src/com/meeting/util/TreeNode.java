package com.meeting.util;

import java.util.ArrayList;

import com.google.gson.Gson;

public class TreeNode {
	private String id;
	private String pid;//���ڵ�ID
	private String name;//����
	private String remark;//��ע
	
	private ArrayList<TreeNode> children = new ArrayList<TreeNode>();
	public TreeNode(String id, String pid, String name, String remark) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.remark = remark;
	}
	public void add(TreeNode node) {//�ݹ���ӽڵ�
		if ("0".equals(node.pid)) {
			this.children.add(node);
		} else if (node.pid.equals(this.id)) {
			this.children.add(node);
		} else {
			for (TreeNode tmp_node : children) {
				tmp_node.add(node);
			}
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ArrayList<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<TreeNode> children) {
		this.children = children;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode("0", "0", "������˾", "������˾-��ע");
		TreeNode node = null;
		node = new TreeNode("1", "0", "���ݷֹ�˾", "11AAA");
		root.add(node);
		node = new TreeNode("2", "0", "���ŷֹ�˾", "11BBB");
		root.add(node);
		node = new TreeNode("3", "1", "���ݷֹ�˾-1����", "11CCC");
		root.add(node);
		node = new TreeNode("4", "1", "���ݷֹ�˾-2����", "11CCC");
		root.add(node);
		node = new TreeNode("5", "2", "���ŷֹ�˾-1����", "11CCC");
		root.add(node);
		node=new TreeNode("6","5","���ŷֹ�˾-1����-�г���","�г���");
		root.add(node);
		Gson gson=new Gson();
		String json=gson.toJson(root.getChildren());
		System.out.println(json);
	}
}
