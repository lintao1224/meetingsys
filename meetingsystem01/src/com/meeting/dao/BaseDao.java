package com.meeting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	//JDBC 来完成  导入驱动包
	String driverClassName="com.mysql.jdbc.Driver";
	String dbUserName="root";
	String password="root";
	String url="jdbc:mysql://localhost:3306/meetingsystem_mj?useUnicode=true&characterEncoding=utf-8";
	public Connection getConn(){
		//1. 加载驱动程序
		//2. 获取连接
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
		//5. 释放资源
		
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
