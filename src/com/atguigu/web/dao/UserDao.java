package com.atguigu.web.dao;

import java.util.List;

import com.atguigu.web.bean.Employee;
import com.atguigu.web.bean.User;

public interface UserDao {
	
	User findUserByUsernameAndPassword(String username,String password);
	
	boolean validUserNameExist(String username);
	
	List<Employee> getAllEmps();

}
