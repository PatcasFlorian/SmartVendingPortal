package org.fasttrackit.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	// Connection the database
	public Connection getConnectionSocietate()  {
		Properties connectionsProps = new Properties();
		connectionsProps.put("user", "root");
		connectionsProps.put("password", "luca77dgl");
		String nameOfCompany = "microgame33202510";
		 //String dbAddress = "jdbc:mysql://localhost:3306/TIGER?createDatabaseIfNotExist=true";
		String createDataBase = "CREATE TABLE IF NOT EXISTS "+nameOfCompany;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nameOfCompany+"?createDatabaseIfNotExist=true",
					connectionsProps);
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
		return null;
	}
	/*
	//Connect of the table  Locatii
	public Connection getConnectionLocatii()  {
		Properties connectionsProps = new Properties();
		connectionsProps.put("user", "root");
		connectionsProps.put("password", "luca77dgl");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_vending_locatii?serverTimezone=UTC",
					connectionsProps);
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
		return null;
	}
	
	//Connect of the table Aparate
	public Connection getConnectionAparate()  {
		Properties connectionsProps = new Properties();
		connectionsProps.put("user", "root");
		connectionsProps.put("password", "luca77dgl");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_vending_aparate?serverTimezone=UTC",
					connectionsProps);
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
		return null;
	}
	
	*/
	//Close of the connection
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	
}

