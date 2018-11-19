package com.atguigu.web.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.atguigu.web.bean.Employee;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonTest {
	
	@Test
	public void testJavaToJsonStr() throws Exception {
		
		Employee employee = new Employee(1, "Mike", "Mike@163.com", "male");
		
		Gson gson = new Gson();
		
		String employeeStr = gson.toJson(employee);
		
		
		
		System.out.println(employeeStr);
		
		Employee fromJson = gson.fromJson(employeeStr, Employee.class);
		
		System.out.println(fromJson);
		
	}
	
	@Test
	public void testJavaCollectionToJsonStr() throws Exception {
		
		List<Employee> emps=new ArrayList<>();
		
		Employee employee1 = new Employee(1, "Mike", "Mike@163.com", "male");
		Employee employee2 = new Employee(1, "Mike", "Mike@163.com", "male");
		Employee employee3 = new Employee(1, "Mike", "Mike@163.com", "male");
		
		emps.add(employee1);
		emps.add(employee2);
		emps.add(employee3);
		
		Gson gson = new Gson();
		
		String empsStr = gson.toJson(emps);
		
		System.out.println(empsStr);
		
		// typeOfT:java.lang.reflect.Type
		List<Employee> fromJson = gson.fromJson(empsStr, new TypeToken<List<Employee>>() {}.getType());
		
		
		System.out.println(fromJson);
	}

}
