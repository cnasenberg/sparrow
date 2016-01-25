package eu.nasenberg.sparrow;

public class User {

	private long id;
    private String username; 
	private String emailAddress; 
	
	public User() {
	}
	
	public User(String username, String emailAddress) {
		this.username = username;
		this.emailAddress = emailAddress; 
	}
	
	public User(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setId(long id){
		this.id = id;  
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

}