package dmacc.beans;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	
	@OneToMany
	private List<Animal> favorites;
	
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", favorites=" + favorites
				+ "]";
	}
	
	/*
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password+ "]";
	}
	*/

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

	
	
	public List<Animal> getFavorites() {
		return favorites;
	}


	public void setFavorites(List<Animal> favorites) {
		this.favorites = favorites;
	}
	
	

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
