package com.driver.services.impl;

import com.driver.ParkingLot;
import com.driver.Spot;
import com.driver.model.SpotType;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
    	
    	ParkingLot parkingLot=new ParkingLot();
    	parkingLot.setName(name);
    	parkingLot.setAddress(address);
    	parkingLotRepository1.save(parkingLot);
    	return parkingLot;

    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {
    	
    	ParkingLot parkingLot=parkingLotRepository1.findById(parkingLotId).get();
    	List<Spot> listspots=parkingLot.getSpots();
    	Spot spot=new Spot();
    	spot.setOccupaid(true);
    	spot.setPriceperHour(pricePerHour);
    	switch(numberOfWheels)
    	{
    	case 2 : spot.setSpotType(SpotType.TWO_WHEELER);
    		      break;
    		      
    	case 4 : spot.setSpotType(SpotType.FOUR_WHEELER);
    			  break;
    	
    	default: spot.setSpotType(SpotType.OTHERS);
    			 break;
    	}
    	
    	listspots.add(spot);
  
    	parkingLot.setSpots(listspots);
    	
    	parkingLotRepository1.save(parkingLot);
    	spotRepository1.save(spot);
    	
		return spot;

    }

    @Override
    public void deleteSpot(int spotId) {
    	
    	spotRepository1.deleteById(spotId);

    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {
    	
    	ParkingLot parkingLot =parkingLotRepository1.findById(parkingLotId).get();
    	List<Spot> listSpots=parkingLot.getSpots();
    	Spot pot=null;
    	for(Spot spot:listSpots)
    	{
    		if(spot.getId()==spotId)
    		{
    			pot=spot;
    			listSpots.remove(spot);
    			break;
    		}
    	}
    	pot.setPriceperHour(pricePerHour);
    	listSpots.add(pot);
    	parkingLot.setSpots(listSpots);
    	spotRepository1.save(pot);
    	parkingLotRepository1.save(parkingLot);
    	
		return pot;

    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
    	
    	parkingLotRepository1.deleteById(parkingLotId);

    }
}
