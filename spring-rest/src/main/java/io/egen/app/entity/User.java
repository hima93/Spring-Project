package io.egen.app.entity;



import java.util.UUID;

import javax.persistence.*;


@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT e from User e ORDER BY e.username"),
	@NamedQuery(name = "User.findByusername", query = "SELECT e from User e where e.username=:pusername")
})

public class User {

	@Id
	private String id;

	 private String firstName;
	 private String lastName;
	 @Column(unique = true)
     private String username;
     private String password;
     
     private String confirmPassword;
     
     @ManyToOne 
    private Role role;
      
 	

 	public User() {
 		id = UUID.randomUUID().toString();
 	}

 	
     public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getusername() {
		return username;
	}



	public void setusername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	

	

	 

	

	


}