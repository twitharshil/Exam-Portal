package com.onlineportal.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnectionFactory {
	
	private static Connection con = null;
	private static String JDBC_DRIVER;
	private static String USER;
	private static String PASSWORD;
	private static String URL;
	
	static {
		loadPropertyFile();
		connect();
	}
	
	private static void connect() {
		 try{
     	    Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(URL,USER,PASSWORD);
				if (con != null) {
					System.out.println("connection created successfully using properties file");
				}
				else {
					System.out.println(" unable to create connection");
				}
			
          } catch (ClassNotFoundException e) {
				
			       	e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	
	private static void loadPropertyFile() {
		Properties prop = new Properties();
		try {
			InputStream is = new FileInputStream("/DB.properties");
			prop.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JDBC_DRIVER = prop.getProperty("JDBC_DRIVER");
		USER = prop.getProperty("USER");
		PASSWORD = prop.getProperty("PASSWORD");
	}
	
	public static Connection getConnection() {
		return con;
	}
}
