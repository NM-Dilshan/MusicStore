package addSong;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class addSong_Control {
	
	//connect data base
	private static boolean isSucces;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//insert music data
	
	public static boolean insertdata(String songName,String artistEmail, String filePath,String date,String description,String artistName) {
		boolean isSucces = false;
		
		try {
			//data base connection call
			con = addSong_dbConection.getConnection();
			stmt = con.createStatement();
			
			//SQL insert
			String sql = "insert into addsong(id,songName,artistEmail,filePath,date,description,artistName) values (0,'"+songName+"','"+artistEmail+"','"+filePath+"','"+date+"','"+description+"','"+artistName+"')";
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
	

	//artist all data display
	
	public static List<addSong_Model> getById (String id,String email){
		 
		 ArrayList<addSong_Model>music = new ArrayList<>();
		 
		 try {//db connection
			 con=addSong_dbConection.getConnection();
			 stmt=con.createStatement();
			 
			 //query
			 String sql = "select * from addsong where  artistEmail='"+email+"'";
			 rs = stmt.executeQuery(sql);
			 while(rs.next()) {
				 int Id = rs.getInt("id");
			 	String songName = rs.getString("songName");
			 	String Email = rs.getString("artistEmail");
			 	String filePath = rs.getString("filePath");
				String date = rs.getString("date");
				String description = rs.getString("description");
				String artistName = rs.getString("artistName");
				addSong_Model re = new addSong_Model(Id,songName,Email,filePath,date,description,artistName);
				music.add(re);
			 	
			 	
			 }	 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 System.out.println(e);
		 }
		 return music;
	}
	
	
	//delete data
	
	public static List<addSong_Model> getById1 (String id){
		 
		 ArrayList<addSong_Model>music1 = new ArrayList<>();
		 
		 try {//db connection
			 con=addSong_dbConection.getConnection();
			 stmt=con.createStatement();
			 
			 //query
			 String sql = "select * from addsong where  id='"+id+"'";
			 rs = stmt.executeQuery(sql);
			 while(rs.next()) {
				 int Id = rs.getInt("id");
			 	String songName = rs.getString("songName");
			 	String Email = rs.getString("artistEmail");
			 	String filePath = rs.getString("filePath");
				String date = rs.getString("date");
				String description = rs.getString("description");
				String artistName = rs.getString("artistName");
				addSong_Model re = new addSong_Model(Id,songName,Email,filePath,date,description,artistName);
				music1.add(re);
			 	
			 	
			 }	 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 System.out.println(e);
		 }
		 return music1;
	}
	
	
	public static boolean deletedata(String id) {
		int convID=Integer.parseInt(id);
		
		try {
			//dbConnection
			
			con = addSong_dbConection.getConnection();
			stmt = con.createStatement();
			String sql = "delete from addsong where id='"+convID+"'";
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
	
	
	//Song UPDATE DATA
	public static boolean update(String Id,String songName,String artistEmail, String filePath,String date,String description,String artistName) {
		try {
			 //DB conection
			con=addSong_dbConection.getConnection();
			stmt=con.createStatement();
			
			//SQL query
			String sql ="update addSong set songName='"+songName+"',artistEmail='"+artistEmail+"',filePath='"+filePath+"',date='"+date+"',description='"+description+"',artistName='"+artistName+"'"
					+"where id='"+Id+"'";
			
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
