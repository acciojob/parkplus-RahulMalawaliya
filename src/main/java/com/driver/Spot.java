package com.driver;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.driver.model.SpotType;

@Entity
@Table
public class Spot {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Enumerated(EnumType.STRING)
	private SpotType spotType;
	
	private int priceperHour;
	
	private Boolean Occupaid;
	
	@OneToMany
	@JoinColumn
	private ParkingLot parkingLot;
	
	@OneToMany(mappedBy = "spot",cascade = CascadeType.ALL)
	private List<Reservation> reservations;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public SpotType getSpotType() {
		return spotType;
	}

	public void setSpotType(SpotType spotType) {
		this.spotType = spotType;
	}

	public int getPriceperHour() {
		return priceperHour;
	}

	public void setPriceperHour(int priceperHour) {
		this.priceperHour = priceperHour;
	}

	public Boolean getOccupaid() {
		return Occupaid;
	}

	public void setOccupaid(Boolean occupaid) {
		Occupaid = occupaid;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Spot(int id, SpotType spotType, int priceperHour, Boolean occupaid, ParkingLot parkingLot,
			List<Reservation> reservations) {
		super();
		Id = id;
		this.spotType = spotType;
		this.priceperHour = priceperHour;
		Occupaid = occupaid;
		this.parkingLot = parkingLot;
		this.reservations = reservations;
	}

	public Spot() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
