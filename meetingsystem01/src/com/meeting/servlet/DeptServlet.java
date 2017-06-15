package com.meeting.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.service.DeptService;
import com.meeting.service.IDeptService;

public class DeptServlet extends HttpServlet {
	IDeptService deptService;
	/**
	 * Constructor of the object.
	 */
	public DeptServlet() {
		super();
		deptService=new DeptService();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String opertype=request.getParameter("opertype");
		//չʾ���в���
		if (opertype.equals("showDepts")) {
			String json = deptService.deptListJson();
			out.print(json);
		}
		//���ݲ���ID��ѯ������Ա
		else if(opertype.equals("searchUserlist")){
			//��ȡ���� ����ID
			String dept_id=request.getParameter("dept_id");
			String json=deptService.getUsersByDeptId(dept_id);
			out.print(json);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
