package com.ram.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {

	private String jdbcDriver = "com.mysql.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/questionPaperGeneratorDb";
	private String jdbcUser = "root";
	private String jdbcPassword = "root";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
