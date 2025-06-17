package admin;

import java.sql.Connection;
import java.sql.DriverManager;

public class admindbConnection {

	private static String url = "jdbc:mysql://127.0.0.1:3306/musicstore";
	private static String user = "root";
	private static String pass = "1228";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
			
		}
		catch(Exception e) {
			System.out.println("Data base Not connect");
			
		}
		return con;
	}
}
