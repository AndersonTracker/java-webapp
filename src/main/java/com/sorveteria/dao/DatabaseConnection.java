package com.sorveteria.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	final String DB_URL = "jdbc:sqlite:C:/Projetos/JAVA/JAVA_API/database/sqlitedb.db";
	final String USER = "admin";
	final String PASSWORD = "C0nnect123";

	Connection dbconnection;

	public DatabaseConnection() {
		try {
			dbconnection = (Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
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
