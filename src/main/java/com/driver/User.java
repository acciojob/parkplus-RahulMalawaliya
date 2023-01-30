package com.driver;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String name;
	
	private String PhoneNumber;
	
	private String Password;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Reservation> ListReservations;


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return PhoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public List<Reservation> getListReservations() {
		return ListReservations;
	}


	public void setListReservations(List<Reservation> listReservations) {
		ListReservations = listReservations;
	}


	public User(int id, String name, String phoneNumber, String password, List<Reservation> listReservations) {
		super();
		Id = id;
		this.name = name;
		PhoneNumber = phoneNumber;
		Password = password;
		ListReservations = listReservations;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
