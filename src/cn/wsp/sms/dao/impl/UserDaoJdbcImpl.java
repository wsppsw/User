package cn.wsp.sms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



import cn.wsp.sms.dao.IUserDao;
import cn.wsp.sms.domain.Student;
import cn.wsp.sms.domain.User;
import cn.wsp.sms.util.JdbcUtils;


public class UserDaoJdbcImpl implements IUserDao {

	@Override
	public User findByName(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User user = null;
		
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				String password = rs.getString("password");
				int id = rs.getInt("id");
				user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int add(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int n = 0;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into t_user (username,password) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			n = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}
	

	@Override
	public List<User> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<User> alluser = null;
		boolean flag = true;
		
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "select * from t_user";
			ps = conn.prepareStatement(sql);
			
			//3.执行查询
			rs = ps.executeQuery();
			
			while(rs.next()){
				if(flag){
					alluser = new LinkedList<User>();
					flag = false;
				}
				User su = new User();
		
				su.setId(rs.getInt("id"));
				su.setUsername(rs.getString("username"));
				su.setPassword(rs.getString("password"));
				
				
						
				
				alluser.add(su);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.free(rs, ps, conn);
			
		}
		
		
		return alluser;
	}

	@Override
	public User findByPassword(String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User user = null;
		
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_user where password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				String username = rs.getString("username");
				
				user = new User();
				user.setUsername(username);
				user.setPassword(password);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int  modify(int id, User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int i = 0;
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "update t_user set password = ? where id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getPassword());
			ps.setInt(2, id);
			
			//3.执行sql
			i = ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.free(rs, ps, conn);
			
		}
		return i;
	}
}
