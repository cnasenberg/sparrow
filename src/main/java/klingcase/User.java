package klingcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class User {

	private long id;
    private String username; 
	private String emailAddress; 
	
	public User(String username, String emailAddress) {
		this.setUsername(username);
		this.setEmailAddress(emailAddress); 
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