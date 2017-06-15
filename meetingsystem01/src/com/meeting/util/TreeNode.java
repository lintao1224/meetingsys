package com.meeting.util;

import java.util.ArrayList;

import com.google.gson.Gson;

public class TreeNode {
	private String id;
	private String pid;//父节点ID
	private String name;//名称
	private String remark;//备注
	
	private ArrayList<TreeNode> children = new ArrayList<TreeNode>();
	public TreeNode(String id, String pid, String name, String remark) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.remark = remark;
	}
	public void add(TreeNode node) {//递归添加节点
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
		TreeNode root = new TreeNode("0", "0", "福建公司", "福建公司-备注");
		TreeNode node = null;
		node = new TreeNode("1", "0", "福州分公司", "11AAA");
		root.add(node);
		node = new TreeNode("2", "0", "厦门分公司", "11BBB");
		root.add(node);
		node = new TreeNode("3", "1", "福州分公司-1部门", "11CCC");
		root.add(node);
		node = new TreeNode("4", "1", "福州分公司-2部门", "11CCC");
		root.add(node);
		node = new TreeNode("5", "2", "厦门分公司-1部门", "11CCC");
		root.add(node);
		node=new TreeNode("6","5","厦门分公司-1部门-市场部","市场部");
		root.add(node);
		Gson gson=new Gson();
		String json=gson.toJson(root.getChildren());
		System.out.println(json);
	}
}
