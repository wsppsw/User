package cn.wsp.sms.dao;

import java.util.List;

import cn.wsp.sms.domain.Student;
import cn.wsp.sms.domain.User;

public interface IUserDao {
	public User findByName(String username);
	public int add(User user);
	public List<User> findAll();
	public User findByPassword(String password);
	public int  modify(int id,User user);
}
