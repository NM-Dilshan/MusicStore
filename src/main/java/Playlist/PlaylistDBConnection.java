package Playlist;

import java.sql.Connection;
import java.sql.DriverManager;

public class PlaylistDBConnection {


	private static String url = "jdbc:mysql://127.0.0.1:3306/musicstore";
	private static String user = "root";
	private static String pass = "1228";
	private static Connection con;
	
	 public static Connection getConnetion() {
	 
	 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection(url,user,pass);
		 
		 }
	  catch(Exception e) {
		 
		 System.out.println("Database Not Connect !");
	  }
      return con;
   }


}
