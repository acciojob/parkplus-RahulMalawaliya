package com.driver;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.driver.model.PaymentMode;

@Entity
@Table
public class Payment {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private boolean paymentcomplete;
	
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;
	
	@OneToOne(mappedBy = "payment",cascade = CascadeType.ALL)
	private Reservation reservations;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPaymentcomplete() {
		return paymentcomplete;
	}

	public void setPaymentcomplete(boolean paymentcomplete) {
		this.paymentcomplete = paymentcomplete;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Reservation getReservations() {
		return reservations;
	}

	public void setReservations(Reservation reservations) {
		this.reservations = reservations;
	}

	public Payment(int id, boolean paymentcomplete, PaymentMode paymentMode, Reservation reservations) {
		super();
		this.id = id;
		this.paymentcomplete = paymentcomplete;
		this.paymentMode = paymentMode;
		this.reservations = reservations;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
