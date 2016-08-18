package edu.elt.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public static Connection recuperarConexion()
			throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ejemplo";
		
		Class.forName(driver);
		
		return DriverManager.getConnection(url, "root", "password");
	}
	
	public static void cerrarConexion(Connection connection) {
		if(connection != null) {
 			try {
 				connection.close();
 			} catch(SQLException e) {
 				System.out.println("SQL Exception: " + e.getSQLState());
 				e.printStackTrace();
 			}
 		}	
	}
}
