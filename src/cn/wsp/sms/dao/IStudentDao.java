package cn.wsp.sms.dao;

import java.util.List;

import cn.wsp.sms.domain.Student;

public interface IStudentDao {
	public List<Student> findAll();
	public Student findById(int id);
	public int add(Student stu);
	public int modify(int id,Student stu);
	public int delete(int id);
	public List<Student> findlikename(String name);//ģ����ѯ
	public List<Student> findlikclass(String findclass);
	public List<Student> findlikid(int id);
	/* ���ڲ�ѯ��¼�������ķ������÷������ڷ�ҳ����ģ��  */
	public int findTotalCount();
	//��ѯһҳ�ļ�¼
	public List<Student> findOnePage(int pageIndex,int pageSize);
	
}
