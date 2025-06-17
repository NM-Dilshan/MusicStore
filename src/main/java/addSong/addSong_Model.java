package addSong;

public class addSong_Model {
	
	private int id;
	private String songName;
	private String artistEmail;
	private String filePath;
	private String date;
	private String description;
	private String artistName;
	
	
	public addSong_Model(int id, String songName, String artistEmail, String filePath, String date, String description,String artistName) {
		
		
		this.id = id;
		this.songName = songName;
		this.artistEmail = artistEmail;
		this.filePath = filePath;
		this.date = date;
		this.description = description;
		this.artistName = artistName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSongName() {
		return songName;
	}


	public void setSongName(String songName) {
		this.songName = songName;
	}


	public String getArtistEmail() {
		return artistEmail;
	}


	public void setArtistEmail(String artistEmail) {
		this.artistEmail = artistEmail;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getArtistName() {
		return artistName;
	}


	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	

	
	
	

}
