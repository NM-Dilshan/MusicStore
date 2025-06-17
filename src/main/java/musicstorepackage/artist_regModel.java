package musicstorepackage;

public class artist_regModel {
	
	private int id;
	private String fullName;
	private String email;
	private String password;
	private String artistCode;
	private String phone;
	
	
	public artist_regModel(int id, String fullName, String email, String password, String artistCode, String phone) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.artistCode = artistCode;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getArtistCode() {
		return artistCode;
	}
	public void setArtistCode(String artistCode) {
		this.artistCode = artistCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
 