package cn.wsp.sms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.domain.Student;
import cn.wsp.sms.util.JdbcUtils;

public class StudentDaoJDBCImpl implements IStudentDao {

	@Override
	public List<Student> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> allStu = null;
		boolean flag = true;
		
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "select * from t_student";
			ps = conn.prepareStatement(sql);
			
			//3.执行查询
			rs = ps.executeQuery();
			
			while(rs.next()){
				if(flag){
					allStu = new LinkedList<Student>();
					flag = false;
				}
				Student stu = new Student();
				
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setMyclass(rs.getString("myclass"));
				stu.setScore(rs.getDouble("score"));
						
				
				allStu.add(stu);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.free(rs, ps, conn);
			
		}
		
		
		return allStu;
	}

	
	
	
	@Override
	public Student findById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Student stu = null;
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "select * from t_student where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			//3.执行查询
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				String name = rs.getString("name");
				String myclass=rs.getString("myclass");
				Double score=rs.getDouble("score");
				
				stu = new Student();
				stu.setId(id);
				stu.setName(name);
				stu.setMyclass(myclass);
				stu.setScore(score);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.free(rs, ps, conn);
			
		}
		return stu;
	}

	@Override
	public int add(Student stu) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int i = 0;
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "insert into t_student(name,myclass,score) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,stu.getName());
			ps.setString(2, stu.getMyclass());
			ps.setDouble(3, stu.getScore());
			
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

	@Override
	public int modify(int id, Student stu) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int i = 0;
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "update t_student set name = ?, myclass = ?,score = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,stu.getName());
			ps.setString(2, stu.getMyclass());
			ps.setDouble(3, stu.getScore());
			ps.setInt(4, id);
			
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

	@Override
	public int delete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int i = 0;
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "delete from t_student where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
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

	@Override
	public int findTotalCount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int totalCount = 0;
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "select count(*) as totalcount from t_student";
			ps = conn.prepareStatement(sql);
			
			//3.执行查询
			rs = ps.executeQuery();
			
			if(rs.next()){
				totalCount = rs.getInt("totalcount");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.free(rs, ps, conn);
			
		}
		return totalCount;
	}
	
	
	public List<Student> findlikename(String name){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> allStu = null;
		boolean flag = true;
		
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "select * from t_student where name like '%"+name+"%'";
			ps = conn.prepareStatement(sql);
			
			//3.执行查询
			rs = ps.executeQuery();
			
			while(rs.next()){
				if(flag){
					allStu = new LinkedList<Student>();
					flag = false;
				}
				Student stu = new Student();
				
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setMyclass(rs.getString("myclass"));
				stu.setScore(rs.getDouble("score"));
						
				
				allStu.add(stu);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.free(rs, ps, conn);
			
		}
		
		
		return allStu;
	}

	@Override
	public List<Student> findOnePage(int pageIndex, int pageSize) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> stuList = null;
		
		int start = (pageIndex - 1) * pageSize;
		
		
		boolean flag = true;
		
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "select * from t_student limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, pageSize);
			
			//3.执行查询
			rs = ps.executeQuery();
			
			while(rs.next()){
				if(flag){
					stuList = new LinkedList<Student>();
					flag = false;
				}
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String myclass = rs.getString("myclass");
				double score = rs.getDouble("score");
				
				Student stu = new Student();
				stu.setId(id);
				stu.setName(name);
				stu.setMyclass(myclass);
				stu.setScore(score);
				
				stuList.add(stu);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.free(rs, ps, conn);
			
		}
		
		
		return stuList;
	}


	@Override
	public List<Student> findlikclass(String findclass) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> allStu = null;
		boolean flag = true;
		
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "select * from t_student where myclass like '%"+findclass+"%'";
			ps = conn.prepareStatement(sql);
			
			//3.执行查询
			rs = ps.executeQuery();
			
			while(rs.next()){
				if(flag){
					allStu = new LinkedList<Student>();
					flag = false;
				}
				Student stu = new Student();
				
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setMyclass(rs.getString("myclass"));
				stu.setScore(rs.getDouble("score"));
						
				
				allStu.add(stu);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.free(rs, ps, conn);
			
		}
		
		
		return allStu;
	}




	@Override
	public List<Student> findlikid(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> allStu = null;
		boolean flag = true;
		
		
		try {
			//1.创建连接
			conn = JdbcUtils.getConnection();
			
			//2.创建语句对象
			String sql = "select * from t_student where id ="+id+"";
			ps = conn.prepareStatement(sql);
			
			//3.执行查询
			rs = ps.executeQuery();
			
			while(rs.next()){
				if(flag){
					allStu = new LinkedList<Student>();
					flag = false;
				}
				Student stu = new Student();
				
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setMyclass(rs.getString("myclass"));
				stu.setScore(rs.getDouble("score"));
						
				
				allStu.add(stu);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.free(rs, ps, conn);
			
		}
		
		
		return allStu;
	}

}
