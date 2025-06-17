package musicstorepackage_feedback;

public class feedbackmodel {
	
	private int feedbackID;
	private String username;
	private String massage;
	private String email;
	
	public int getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public feedbackmodel(int feedbackID, String username, String massage, String email) {
		super();
		this.feedbackID = feedbackID;
		this.username = username;
		this.massage = massage;
		this.email = email;
	}
	

	

}
