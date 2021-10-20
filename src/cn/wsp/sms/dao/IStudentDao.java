package cn.wsp.sms.dao;

import java.util.List;

import cn.wsp.sms.domain.Student;

public interface IStudentDao {
	public List<Student> findAll();
	public Student findById(int id);
	public int add(Student stu);
	public int modify(int id,Student stu);
	public int delete(int id);
	public List<Student> findlikename(String name);//模糊查询
	public List<Student> findlikclass(String findclass);
	public List<Student> findlikid(int id);
	/* 用于查询记录总条数的方法，该方法用在分页功能模块  */
	public int findTotalCount();
	//查询一页的记录
	public List<Student> findOnePage(int pageIndex,int pageSize);
	
}
