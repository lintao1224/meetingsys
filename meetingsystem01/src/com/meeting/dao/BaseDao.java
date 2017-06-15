package com.meeting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	//JDBC �����  ����������
	String driverClassName="com.mysql.jdbc.Driver";
	String dbUserName="root";
	String password="root";
	String url="jdbc:mysql://localhost:3306/meetingsystem_mj?useUnicode=true&characterEncoding=utf-8";
	public Connection getConn(){
		//1. ������������
		//2. ��ȡ����
		Connection con=null;
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, dbUserName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeAll(ResultSet rs,Statement stmt,Connection con){
		//5. �ͷ���Դ
		
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
