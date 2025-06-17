package musicstorepackage_feedback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class feedbackcontroller {

	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	

	public static boolean insertdata(String username, String massage, String email)
	{
		boolean isSuccess = false;
		
		try {
			//DB connection
			con = DBconnection.getConnection();
			stmt = con.createStatement();
			
			//sqlquery
			String sql = "insert into feedback values(0,'"+username+"','"+massage+"','"+email+"')";
			int rs = stmt.executeUpdate(sql);
			if(rs>0) {
				isSuccess = true;
				
			}else {
				isSuccess = false;
			}
				
		}catch(Exception e) {
			e.printStackTrace(); 
			}
		
		return isSuccess;
		
	}
	//getByID
	public static List<feedbackmodel> getById(String feedbackI){
		
		int convertedID = Integer.parseInt(feedbackI);
		ArrayList<feedbackmodel> feedbacks = new ArrayList<>();
		
		try {
			//DBcon
			con = DBconnection.getConnection();
			stmt = con.createStatement();
			
			//query
			String sql = "select * from feedback where id '"+convertedID+"'";
			
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				int feedbackID= rs.getInt(1);
				String username = rs.getString(2);
				String massage = rs.getString(3);
				String email = rs.getString(4);
		
				feedbackmodel fd = new feedbackmodel(feedbackID,username,massage,email);
				feedbacks.add(fd);
			}
			
		}catch(Exception e) {
			e.printStackTrace(); 
			}
		
		return feedbacks;
	}
	
	//getall
	public static List<feedbackmodel> getAllfeedback(){
		
		ArrayList<feedbackmodel> feedbacks = new ArrayList<>();
		
		try {
			//DBcon
			con = DBconnection.getConnection();
			stmt = con.createStatement();
			
			//query
			String sql = "select * from feedback";
			
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				int feedbackID = rs.getInt(1);
				String username = rs.getString(2);
				String massage = rs.getString(3);
				String email = rs.getString(4);
		
				feedbackmodel fd = new feedbackmodel(feedbackID,username,massage,email);
				feedbacks.add(fd);
			}
			
		}catch(Exception e) {
			e.printStackTrace(); 
			}
		
		return feedbacks;
	}
	
	//update 
	public static boolean updatedata(String feedbackID,String username, String massage, String email)
	{

		try {
			//DB connection
			con = DBconnection.getConnection();
			stmt = con.createStatement();
			
			//sqlquery
			String sql = "update feedback set username ='"+username+"', massage ='"+massage+"', email ='"+email+"'"
					+"where feedbackID='"+feedbackID+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
				
			}else {
				isSuccess = false;
			}
				
		}catch(Exception e) {
			e.printStackTrace(); 
			}
		
		return isSuccess;
	}
	
	
	//delete
		public static boolean deletedata(String feedbackID)
		{
			 if (feedbackID == null || feedbackID.trim().isEmpty()) {
			        System.err.println("Invalid feedback ID: null or empty");
			        return false;
			    }
			 
			int convID = Integer.parseInt(feedbackID);

			try {
				//DB connection
				con = DBconnection.getConnection();
				stmt = con.createStatement();
				
				//sqlquery
				String sql = "delete from feedback where feedbackID='"+convID+"'";
				
					
				
				int rs = stmt.executeUpdate(sql);
				
				if(rs>0) {
					isSuccess = true;
					
				}else {
					isSuccess = false;
				}
					
			}catch(Exception e) {
				e.printStackTrace(); 
				}
			
			return isSuccess;
		}
	
		
		
}
