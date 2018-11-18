package com.atguigu.web.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {
	
	private static String user;
	private static String password;
	private static String jdbcUrl;
	private static String driverClass;
	
	private static Properties properties;
	
	private static ThreadLocal<Connection> threadLocal;
	
	// 要求： 一个线程来访问Servlet，来获取Connection验证数据时，最多只能获取一个Connection对象！
	/*
	 *  ThreadLocal<T>:  可以在当前线程上保存数据！
	 *  			T类型就是在当前ThreadLocal要保存的数据类型！
	 *  		数据会保存在ThreadLocal的内置的一个Map中！
	 *  			保存：  set(T)
	 *  			获取： get(T)
	 *  			移除： remove()
	 */
	
	static {
		
		InputStream is = ConnectionUtils.class.getClassLoader().getResourceAsStream("db.properties");
		
		properties=new Properties();
		
		threadLocal=new ThreadLocal<>();
		
		try {
			properties.load(is);
			
			user=properties.getProperty("user");
			password=properties.getProperty("password");
			jdbcUrl=properties.getProperty("jdbcUrl");
			driverClass=properties.getProperty("driverClass");
			
			// 设置驱动类
			Class.forName(driverClass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 从当前的线程上获取链接
	public static Connection getConn() throws SQLException {
		
		Connection connection = threadLocal.get();
		
		if (connection == null) {
			
			connection=DriverManager.getConnection(jdbcUrl, user, password);
			
			threadLocal.set(connection);
		}
		
		return connection;
	}
	
	// 从当前线程关闭链接
	public static void closeConn() throws SQLException {
		
		Connection connection = threadLocal.get();
		
		if (connection !=null && !connection.isClosed()) {
			
			connection.close();
		}
		
		threadLocal.remove();
		
	}

}
