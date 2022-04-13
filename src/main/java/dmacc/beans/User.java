package dmacc.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue
	public long id;
	private String userName;
	private String password;
	//private List<Animal> favorites;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	/*
	public List<Animal> getFavorites() {
		return favorites;
	}


	public void setFavorites(List<Animal> favorites) {
		this.favorites = favorites;
	}

	*/

	public User() {
		super();
	}


	public User(long id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	
}
