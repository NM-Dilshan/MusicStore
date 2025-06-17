package Playlist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaylistController {
	

	//DB Connection Connect
	
	private static boolean isSuccess;
	private static  Connection con =null;
	private static  Statement stmt =null;
	private static ResultSet rs =null;
	
	
	//Insert Data Function
	
	public static boolean insertdata (String title,String artist,String category,String description ) {
		
		boolean isSuccess = false;
		
		try {
			//DB CONNECTION CALL
			con=PlaylistDBConnection.getConnetion();
			stmt=con.createStatement();
			
			//SQL QUERY
			String sql ="insert into playlist values (0,'"+title+"','"+artist+"','"+category+"','"+description+"')";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				 isSuccess=true;
			}
			else {
				isSuccess=false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		return isSuccess;
	}
	
	//GetById
	
		public static List <PlaylistModel> getbyId (String Id){
			
			int ConvertedID = Integer.parseInt(Id);
			
			ArrayList<PlaylistModel> playlist = new ArrayList<>();
			
			try {
				//DB Connection 
				con=PlaylistDBConnection.getConnetion();
				stmt=con.createStatement();
				
				//Query
				
				String sql ="select * from playlist where id '"+ConvertedID+"'";
				rs =stmt.executeQuery(sql);
				 
				while(rs.next()) {
					
					int id =rs.getInt(1);
					String title =rs.getString(2);
					String artist =rs.getString(3);
					String category =rs.getString(4);
					String description =rs.getString(5);
					
					PlaylistModel pl=new PlaylistModel(id,title,artist,category,description);
					playlist.add(pl);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return playlist;
}
			
			//GetAll Data 
			public static List<PlaylistModel> getAllPlaylist(){
				
			ArrayList<PlaylistModel> playlists  = new ArrayList<>();
				
				try {
					//DB Connection 
					con=PlaylistDBConnection.getConnetion();
					stmt=con.createStatement();
					
					//Query
					
					String sql ="select * from playlist ";
					rs =stmt.executeQuery(sql);
					 
					while(rs.next()) {
						
						int id =rs.getInt(1);
						String title =rs.getString(2);
						String artist =rs.getString(3);
						String category =rs.getString(4);
						String description =rs.getString(5);
						
						PlaylistModel pl=new PlaylistModel(id,title,artist,category,description);
						playlists.add(pl);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return playlists;
				
			}
			

	      //Update Data 
			
			public static boolean updatedata(String id,String title,String artist,String category,String description) {
				
				try {
					//DB Connection 
					con=PlaylistDBConnection.getConnetion();
					stmt=con.createStatement();
					
					//Query
					
					String sql ="update playlist set title='"+title+"',artist='"+artist+"',category='"+category+"',description='"+description+"'"
					    +"where id= '"+id+"'";
					 
					
					int rs = stmt.executeUpdate(sql);
					
					if(rs>0) {
						 isSuccess=true;
					}
					else {
						isSuccess=false;
					}
				}
				catch(Exception e) {
					e.printStackTrace();
					
				}
				
				return isSuccess;
			}	

			//Delete Data
			public static boolean deletedata(String id) {
				int convID = Integer.parseInt(id);
				
				try {
				//DB Connection 
				con=PlaylistDBConnection.getConnetion();
				stmt=con.createStatement();
					
				//Query
				String sql ="delete from playlist where id ='"+convID+"'";
				  
				
				int rs = stmt.executeUpdate(sql);
				if(rs>0) {
					 isSuccess = true;
				  }
				else {
					isSuccess = false;
				  }
			}
			     catch(Exception e) {
				     e.printStackTrace();
			     }		
			    return isSuccess;
			
		   }


}
