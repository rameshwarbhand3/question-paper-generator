package com.ram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ram.model.User;
import com.ram.util.MD5HashGenerator;

public class UserDao extends BaseDao {

	private static final String SELECT_USER = "select * from users where username = ? and password = ?";

	private static final String INSERT_USER = "insert into users" + "(username,password,email,firstName,lastName)values"
			+ "(?,?,?,?,?)";

	public boolean validate(User login) throws SQLException {
		boolean status = false;
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(SELECT_USER)) {
			String hashPassword = MD5HashGenerator.generate(login.getPassword());
			// System.out.println(hashPassword);
			pst.setString(1, login.getUsername());
			pst.setString(2, hashPassword);
			ResultSet rs = pst.executeQuery();
			status = rs.next();
		}
		return status;
	}

	public void insert(User user) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement pst = connection.prepareStatement(INSERT_USER)) {
			String hashPassword = MD5HashGenerator.generate(user.getPassword());
			pst.setString(1, user.getUsername());
			pst.setString(2, hashPassword);
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getFirstName());
			pst.setString(5, user.getLastName());
			pst.executeUpdate();
		}
	}
}
