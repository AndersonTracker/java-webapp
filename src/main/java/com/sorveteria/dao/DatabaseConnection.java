package com.sorveteria.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	//final String DB_URL = "jdbc:sqlserver://DESKTOP-7AV68TG\\SQLEXPRESS;databaseName=Sorveteria2;";
	final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Sorveteria2;user=admin;password=admin;";
	// final String USER = "admin";
	// final String PASSWORD = "C0nnect123";

	Connection dbconnection;

	public DatabaseConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			dbconnection = (Connection) DriverManager.getConnection(DB_URL);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Connection getDbconnection() {
		return dbconnection;
	}

	public void closeDBConnection() {
		try {
			dbconnection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
