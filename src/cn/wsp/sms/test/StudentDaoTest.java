package cn.wsp.sms.test;

import java.util.List;

import org.junit.Test;


import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.domain.Student;
import cn.wsp.sms.servlet.CookieEncryptTool;

public class StudentDaoTest {
	
IStudentDao stuDao = new StudentDaoJDBCImpl();
	
	
	//测试findAll()方法
	
IStudentDao studentDao = new StudentDaoJDBCImpl();
	
@Test
public void testFindAll(){
	//List<Student> allStu = studentDao.findAll(); 
	//System.out.print(CookieEncryptTool.encodeBase64("wangshipeng"));
	//for(Student s:allStu)
		//System.out.println(s);
	
	List<Student> stu = studentDao.findlikclass("计科");
	for(Student s:stu) {
		System.out.println(s);
	}
	}

}
