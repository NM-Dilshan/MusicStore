package admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class adminControl {
	//connect data base
	@SuppressWarnings("unused")
	private static boolean isSucces;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static List<adminModel> loginValidate(String email,String password){
		ArrayList<adminModel> user= new ArrayList<>();
		
		try {
			//DB connection
			con = admindbConnection.getConnection();
			stmt = con.createStatement();
			//sql 
			String sql = "SELECT * FROM admin WHERE email='" + email + "' AND password='" + password + "'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String Email = rs.getString(3);
				String Password = rs.getString(4);
	
				
				adminModel u=new adminModel(id,name,Email,Password);
						user.add(u);
						
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			
		}
		return user;
	}
}
