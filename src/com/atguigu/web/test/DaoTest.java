package com.atguigu.web.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atguigu.web.bean.User;
import com.atguigu.web.dao.UserDaoImpl;

public class DaoTest {

	@Test
	public void test() {
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		User user = userDaoImpl.findUserByUsernameAndPassword("jack", "123456");
		
		System.out.println(user);
	}

}
