package com.meeting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.meeting.domain.TUser;
import com.meeting.service.IUserService;
import com.meeting.service.UserService;

public class UserServlet extends HttpServlet {
	private IUserService userSerivce;
	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
		userSerivce=new UserService();
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String opertype=request.getParameter("opertype");//��������
		if(opertype.equals("login_Ajax")){
			//AJax�ش���Ϣ
			String login_name = request.getParameter("login_name");
			String login_password = request.getParameter("login_password");
			TUser user = new TUser();
			user.setLogin_name(login_name);
			user.setLogin_password(login_password);
			if (login_name != null && login_password != null) {
				//������ֲ�����ݿ�
				if (userSerivce.checkLogin(user)) {
					out.print("1");
				} else {
					out.print("0");
				}
			} else {

				out.print("-1");
			}
		}
		
		if(opertype.equals("login_Ajax_json")){
			//AJax�ش���Ϣ
			String login_name = request.getParameter("login_name");
			String login_password = request.getParameter("login_password");
			TUser user = new TUser();
			user.setLogin_name(login_name);
			user.setLogin_password(login_password);
			//JSON��   ����ת��  �Ƽ�ʹ��һ�����  Gson
			Map<String, String> resultMap=new HashMap<String, String>();
			String json="";
			if (login_name != null && login_password != null) {
				//JSON�� ��ԭʼ�ķ�ʽ���Բ����ַ���ƴ��
				/*if (userSerivce.checkLogin(user)) {
					out.print("{\"result\":\"1\",\"message\":\"��¼�ɹ�\"}");
				} else {
					out.print("{\"result\":\"0\",\"message\":\"��¼ʧ��\"}");
				}*/
				
				
				if (userSerivce.checkLogin(user)) {
					resultMap.put("result", "1");
					resultMap.put("message", "��¼�ɹ�");
				} else {
					resultMap.put("result", "0");
					resultMap.put("message", "�û����������");
				}
			} else {
				resultMap.put("result", "-1");
				resultMap.put("message", "����Ϊ��");
				//out.print("{\"result\":\"-1\",\"message\":\"����Ϊ��\"}");
			}
			
			Gson gson=new Gson();
			json=gson.toJson(resultMap);
			out.print(json);
		}
		
		//�������ͣ��û���¼-���ύ��ʽ
		if (opertype.equals("dologin")) {
			String login_name = request.getParameter("login_name");
			String login_password = request.getParameter("login_password");
			TUser user = new TUser();
			user.setLogin_name(login_name);
			user.setLogin_password(login_password);
			if (login_name != null && login_password != null) {
				//������ֲ�����ݿ�
				if (userSerivce.checkLogin(user)) {
					request.getRequestDispatcher("index.jsp").forward(request,
							response);
				} else {
					out.print("user name is "
							+ login_name
							+ " , <font color='blue'>login fails</font> >> <a href='login.jsp'>To login Page </a>");
				}
			} else {

				out.print("parm must not be empty ! <a href='login.jsp'>To login Page </a>");
			}
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
