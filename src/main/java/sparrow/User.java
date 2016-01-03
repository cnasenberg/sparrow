package sparrow;

public class User {

	private long id;
    private String username; 
	private String emailAddress; 
	
	public User(String username, String emailAddress) {
		this.username = username;
		this.emailAddress = emailAddress; 
	}
	
	public User(String username) {
		this.username = username;
	}

	long getId() {
		return id;
	}

	String getUsername() {
		return username;
	}
	
	String getEmailAddress() {
		return emailAddress;
	}

	public void setId(long id){
		this.id = id;  
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

}