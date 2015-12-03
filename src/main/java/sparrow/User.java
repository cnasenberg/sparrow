package sparrow;

public class User {

	private long id;
    private String username; 
	private String emailAddress; 
	
	public User(String username, String emailAddress) {
		this.username = username;
		this.emailAddress = emailAddress; 
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
	
	public void setUsername(String username){
		this.username = username; 
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

}