package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
	private static String url = "jdbc:mysql://localhost:3306/estoque";
	private static String user = "root";
	private static String pass = "root";
 
	
		 
	public static Connection createConnection() {
		Connection conn = null;
		
	if(conn == null) {
		try {
			
		 conn = DriverManager.getConnection(url,user,pass);
		
		}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		return conn;
	
	}
	
	
	public static void closeConnection(Connection con) {
		if(con !=null) {
		try {
			con.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		}
		
	}
	
	
	
	
}
