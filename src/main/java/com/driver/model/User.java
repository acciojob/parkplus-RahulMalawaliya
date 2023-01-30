package com.driver.model;

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
	private List<Reservation> ReservationList;


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


	


	public List<Reservation> getReservationList() {
		return ReservationList;
	}


	public void setReservationList(List<Reservation> reservationList) {
		ReservationList = reservationList;
	}


	


	public User(int id, String name, String phoneNumber, String password, List<Reservation> reservationList) {
		super();
		Id = id;
		this.name = name;
		PhoneNumber = phoneNumber;
		Password = password;
		ReservationList = reservationList;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
