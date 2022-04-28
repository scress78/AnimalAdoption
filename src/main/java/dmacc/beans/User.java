package dmacc.beans;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue
	public long id;
	private String userName;
	private String password;
	private boolean loggedIn;
	@ManyToMany
	private List<Animal> favorites;
	
	public String logOut() {
		if(isLoggedIn() == false) {
			return "User already logged out";
		}
		else {
			loggedIn = false;
			return "User logged out";
		}
	}
	
	public String logIn(String password) {
		if(isLoggedIn() == false) {
			if(password == getPassword()) {
				loggedIn = true;
			return "User has been logged in!";
			}
			else {
				return "Incorrect password!";
			}
		}
		else {
			return "User already logged in!";
		}
	}
	
	public User(long id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	
	public User(long id, String userName, String password, List<Animal> favorites) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.favorites = favorites;
	}
	
}
