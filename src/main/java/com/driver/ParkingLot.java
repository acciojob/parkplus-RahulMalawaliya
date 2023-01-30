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
public class ParkingLot {
	
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String Name;
	
	private String Address;
	
	@OneToMany(mappedBy = "parkingLot",cascade = CascadeType.ALL)
	private List<Spot> spots;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public List<Spot> getSpots() {
		return spots;
	}

	public void setSpots(List<Spot> spots) {
		this.spots = spots;
	}

	public ParkingLot(int id, String name, String address, List<Spot> spots) {
		super();
		Id = id;
		Name = name;
		Address = address;
		this.spots = spots;
	}

	public ParkingLot() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
