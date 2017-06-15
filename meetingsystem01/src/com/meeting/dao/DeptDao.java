package com.meeting.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.meeting.domain.TDept;
import com.meeting.domain.TUser;
/**
 * 部门数据访问对象
 * @author Administrator
 *
 */
public class DeptDao extends BaseDao implements IDeptDao {
	Connection con;
	Statement stmt;
	ResultSet rs;
	@Override
	public List<TDept> getDeptList() {
		List<TDept> list=new ArrayList<TDept>();
		con=super.getConn();
		//3. 命令 并编写SQL语句
		String sql="select * from t_dept";
		try {
			stmt=con.createStatement();
			//4. 获取结果集
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				TDept dept=new TDept();
				dept.setId(rs.getString("id"));
				dept.setName(rs.getString("name"));
				dept.setPid(rs.getString("pid"));
				list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			super.closeAll(rs, stmt, con);
		}
		return list;
	}
	@Override
	public List<TUser> getUsersByDeptId(String dept_id) {
		List<TUser> list=new ArrayList<TUser>();
		con=super.getConn();
		//3. 命令 并编写SQL语句
		String sql="select * from t_user a where a.dept_id='"+dept_id+"' ";
		try {
			stmt=con.createStatement();
			//4. 获取结果集
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				TUser user=new TUser();
				user.setLogin_name(rs.getString("login_name"));
				user.setId(rs.getInt("id"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			super.closeAll(rs, stmt, con);
		}
		return list;
	}

}
