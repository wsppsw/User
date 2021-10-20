package cn.wsp.sms.test;

import java.util.List;

import org.junit.Test;

import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.IUserDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.dao.impl.UserDaoJdbcImpl;
import cn.wsp.sms.domain.Student;
import cn.wsp.sms.domain.User;

public class UserDaoTest {
private IUserDao userDao = new UserDaoJdbcImpl();
	
IUserDao studentDao = new UserDaoJdbcImpl();
	@Test
	public void testFindByName(){
		User user = userDao.findByName("admin");
		
		System.out.println(user);	
	}
	@Test
	public void testFindAll(){
		List<User> allStu = userDao.findAll(); 
		
		for(User s:allStu)
			System.out.println(s);
}
}
