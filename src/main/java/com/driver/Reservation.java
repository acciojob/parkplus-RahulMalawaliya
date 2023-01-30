package com.driver;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Reservation {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int numberOfHours;
	
	@ManyToOne
	@JoinColumn
	private User user;
	
	@ManyToOne
	@JoinColumn
	private Spot spot;
	
	
	@OneToOne
	@JoinColumn
	private Payment payment;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumberOfHours() {
		return numberOfHours;
	}


	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Spot getSpot() {
		return spot;
	}


	public void setSpot(Spot spot) {
		this.spot = spot;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public Reservation(int id, int numberOfHours, User user, Spot spot, Payment payment) {
		super();
		this.id = id;
		this.numberOfHours = numberOfHours;
		this.user = user;
		this.spot = spot;
		this.payment = payment;
	}


	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	

}
