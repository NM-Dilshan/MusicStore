package usermusicstorepackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import musicstorepackage.artist_dbConection;


public class profile_usserControl {
	//connect data base
	private static boolean isSucces;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//insert data
	
	public static boolean insertdata(String firstName,String lastName,String email, String password,String phone) {
		boolean isSucces = false;
		
		try {
			//data base connection call
			con = artist_dbConection.getConnection();
			stmt = con.createStatement();
			
			//SQL insert
			String sql = "insert into userprofile(id,firstNAme,lastName,email,password,phone) values (0,'"+firstName+"','"+lastName+"','"+email+"','"+password+"','"+phone+"')";
			int rs = stmt.executeUpdate(sql);
			if(rs>0) {
				isSucces = true;
			}
			else {
				isSucces = false;
				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return isSucces;
	}
	
	//login validate
	public static List<profile_userModel> loginValidate(String email,String password){
		ArrayList<profile_userModel> user= new ArrayList<>();
		
		try {
			//DB connection
			con = profile_dbConnection.getConnection();
			stmt = con.createStatement();
			//sql 
			String sql = "SELECT * FROM userprofile WHERE email='" + email + "' AND password='" + password + "'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String larstName = rs.getString(3);
				String Email = rs.getString(4);
				String Password = rs.getString(5);
				String phone = rs.getString(6);
				
				profile_userModel u=new profile_userModel(id,firstName,larstName,Email,Password,phone);
						user.add(u);
						
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			
		}
		return user;
	}
	
	//display control
	
	public static List<profile_userModel> profile(String id){
		int convertID=Integer.parseInt(id); 
		
		ArrayList<profile_userModel> user = new ArrayList<>();
		
		try {
			//DB connection
			con = profile_dbConnection.getConnection();
			stmt = con.createStatement();
			//sql 
			String sql = "select * from userprofile where id='"+convertID+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int Id = rs.getInt(1);
				String firstName = rs.getString(2);
				String larstName = rs.getString(3);
				String Email = rs.getString(4);
				String Password = rs.getString(5);
				String phone = rs.getString(6);
				
				profile_userModel u=new profile_userModel(Id,firstName,larstName,Email,Password,phone);
				user.add(u);
						
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return user;
		
	}
	

	//profile update
	public static boolean updateprofile(String id,String firstName,String lastName,String email, String password,String phone) {
		try {
			 //DB conection
			con=artist_dbConection.getConnection();
			stmt=con.createStatement();
			
			//SQL query
			String sql ="update userprofile set firstName='"+firstName+"',lastName='"+lastName+"',email='"+email+"',password='"+password+"',phone='"+phone+"'"
					+"where id='"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			

			if(rs>0) {
				isSucces = true;
			}
			else {
				isSucces = false;
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return isSucces;
	}
	
	//display control
	
	public static List<profile_userModel> getById(String id){
		int convertID=Integer.parseInt(id); 
		
		ArrayList<profile_userModel> user = new ArrayList<>();
		
		try {
			//DB connection
			con = profile_dbConnection.getConnection();
			stmt = con.createStatement();
			//sql 
			String sql = "select * from userprofile where id='"+convertID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int Id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String Email = rs.getString(4);
				String Password = rs.getString(5);
				String phone = rs.getString(6);
				
				profile_userModel u=new profile_userModel(Id,firstName,lastName,Email,Password,phone);
				user.add(u);
						
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return user;
		
	}
	
	//profile delete data
	
	public static boolean deleteProfile(String id) {
		int convID=Integer.parseInt(id);
		
		try {
			//dbConnection
			
			con = profile_dbConnection.getConnection();
			stmt = con.createStatement();
			String sql = "delete from userprofile where id='"+convID+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSucces = true;
			}
			else {
				isSucces = false;
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return isSucces;
	}


}
