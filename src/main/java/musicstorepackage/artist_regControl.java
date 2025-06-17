package musicstorepackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import usermusicstorepackage.profile_dbConnection;


public class artist_regControl {
	
	//connect data base
	private static boolean isSucces;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//insert data
	
	public static boolean insertdata(String fullName,String email, String password,String artistCode,String phone) {
		boolean isSucces = false;
		
		try {
			//data base connection call
			con = artist_dbConection.getConnection();
			stmt = con.createStatement();
			
			//SQL insert
			String sql = "insert into userreg(id,fullName,email,password,artistCode,phone) values (0,'"+fullName+"','"+email+"','"+password+"','"+artistCode+"','"+phone+"')";
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
	public static List<artist_regModel> loginValidate(String email,String password){
		ArrayList<artist_regModel> user= new ArrayList<>();
		
		try {
			//DB connection
			con = profile_dbConnection.getConnection();
			stmt = con.createStatement();
			//sql 
			String sql = "SELECT * FROM userreg WHERE email='" + email + "' AND password='" + password + "'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String fullName = rs.getString(2);
				String Email = rs.getString(3);
				String Password = rs.getString(4);
				String artistCode = rs.getString(5);
				String phone = rs.getString(6);
				
				artist_regModel u=new artist_regModel(id,fullName,Email,Password,artistCode,phone);
						user.add(u);
						
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			
		}
		return user;
	}
	
	//artist profile display control
	
	public static List<artist_regModel> profile(String id){
		int convertID=Integer.parseInt(id); 
		
		ArrayList<artist_regModel> user = new ArrayList<>();
		
		try {
			//DB connection
			con = artist_dbConection.getConnection();
			stmt = con.createStatement();
			//sql 
			String sql = "select * from userreg where id='"+convertID+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int Id = rs.getInt(1);
				String fullName = rs.getString(2);
				String Email = rs.getString(3);
				String Password = rs.getString(4);
				String artistCode = rs.getString(5);
				String phone = rs.getString(6);
				
				artist_regModel u=new artist_regModel(Id,fullName,Email,Password,artistCode,phone);
						user.add(u);
						
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return user;
		
	}
	
	//artist all data display
	
	public static List<artist_regModel> getById (String Id){
		 int convertedID = Integer.parseInt(Id);
		 ArrayList<artist_regModel>userreg = new ArrayList<>();
		 
		 try {//db connection
			 con=artist_dbConection.getConnection();
			 stmt=con.createStatement();
			 
			 //query
			 String sql = "select * from userreg where id = '"+convertedID+"'";
			 rs = stmt.executeQuery(sql);
			 while(rs.next()) {
				 int id = rs.getInt(1);
			 	String fullName = rs.getString(2);
			 	String email = rs.getString(3);
			 	String password = rs.getString(4);
				String artistCode = rs.getString(5);
				String phone = rs.getString(6);
			 	artist_regModel re = new artist_regModel(id,fullName,email,password,artistCode,phone);
			 	userreg.add(re);
			 	
			 	
			 }	 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 System.out.println(e);
		 }
		 return userreg;
	}
	
	
	//Get all data
	public static List<artist_regModel> getAllUserdetails (){
		
		 ArrayList<artist_regModel>userregs = new ArrayList<>();
		 try {//db connection
			 con=artist_dbConection.getConnection();
			 stmt=con.createStatement();
			 
			 //query
			 String sql = "select * from userreg" ;
			 rs = stmt.executeQuery(sql);
			 while(rs.next()) {
				 	int id = rs.getInt(1);
				 	String fullName = rs.getString(2);
				 	String email = rs.getString(3);
				 	String password = rs.getString(4);
					String artistCode = rs.getString(5);
					String phone = rs.getString(6);
				 	artist_regModel re = new artist_regModel(id,fullName,email,password,artistCode,phone);
			 	userregs.add(re);
			 	
			 	
			 }	 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 System.out.println(e);
		 }
		 return userregs;
	}
	
	//UPDATE DATA
	public static boolean update(String id,String fullName,String email, String password,String artistCode,String phone) {
		try {
			 //DB conection
			con=artist_dbConection.getConnection();
			stmt=con.createStatement();
			
			//SQL query
			String sql ="update userreg set fullName='"+fullName+"',email='"+email+"',password='"+password+"',artistCode='"+artistCode+"',phone='"+phone+"'"
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
	
	//delete data
	
	public static boolean deletedata(String id) {
		int convID=Integer.parseInt(id);
		
		try {
			//dbConnection
			
			con = artist_dbConection.getConnection();
			stmt = con.createStatement();
			String sql = "delete from userreg where id='"+convID+"'";
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
