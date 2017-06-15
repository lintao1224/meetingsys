package com.meeting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.meeting.domain.TUser;

public class UserDaoImpl implements IUserDao {

	@Override
	public TUser getUser(TUser user) {
		TUser u=null;
		//JDBC 来完成  导入驱动包
		String driverClassName="com.mysql.jdbc.Driver";
		String dbUserName="root";
		String password="root";
		String url="jdbc:mysql://localhost:3306/meetingsystem_mj?useUnicode=true&characterEncoding=utf-8";
		try {
			//1. 加载驱动程序
			
			Class.forName(driverClassName);
			//2. 获取连接
			Connection con=DriverManager.getConnection(url, dbUserName, password);
			//3. 命令 并编写SQL语句
			String sql="select * from t_user where login_name='"+user.getLogin_name()+"' and login_password='"+user.getLogin_password()+"'";
			Statement stmt=con.createStatement();
			//4. 获取结果集
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				u=new TUser();
				u.setId(rs.getInt("id"));
				u.setLogin_name(	rs.getString("login_name"));
				u.setLogin_password(rs.getString("login_password"));
				u.setPhone(rs.getString("phone"));
				
			}
			//5. 释放资源
			rs.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void addUser(TUser user) {
		// TODO Auto-generated method stub
		
	}

}
