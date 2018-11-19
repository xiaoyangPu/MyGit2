package com.atguigu.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atguigu.web.bean.Employee;
import com.atguigu.web.bean.User;
import com.atguigu.web.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {

		try {

			User user = null;

			Connection conn = ConnectionUtils.getConn();

			String sql = "select * from tbl_user where username=? and password=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				user=new User();

				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setId(rs.getInt("id"));

			}

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				ConnectionUtils.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

	@Override
	public boolean validUserNameExist(String username) {
		
		try {
			
			Connection conn = ConnectionUtils.getConn();

			String sql = "select * from tbl_user where username=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

			return false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				ConnectionUtils.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return false;
	}

	@Override
	public List<Employee> getAllEmps() {
		
		ArrayList<Employee> emps = new ArrayList<>();
		
		try {


			Connection conn = ConnectionUtils.getConn();

			String sql = "select * from tbl_employee";

			PreparedStatement ps = conn.prepareStatement(sql);


			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				Employee employee=new Employee();

				employee.setId(rs.getInt("id"));
				employee.setLastName(rs.getString("last_name"));
				employee.setGender(rs.getString("gender"));
				employee.setEmail(rs.getString("email"));
				
				emps.add(employee);

			}

			return emps;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				ConnectionUtils.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

}
