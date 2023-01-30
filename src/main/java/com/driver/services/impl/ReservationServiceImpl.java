package com.driver.services.impl;

import com.driver.ParkingLot;
import com.driver.Reservation;
import com.driver.Spot;
import com.driver.User;
import com.driver.model.*;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.ReservationRepository;
import com.driver.repository.SpotRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ReservationService;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    UserRepository userRepository3;
    @Autowired
    SpotRepository spotRepository3;
    @Autowired
    ReservationRepository reservationRepository3;
    @Autowired
    ParkingLotRepository parkingLotRepository3;
    @Override
    public Reservation reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception {
    	
    	
    	User user=userRepository3.findById(userId).get();
    	
    	ParkingLot parkingLot=parkingLotRepository3.findById(parkingLotId).get();
    	List<Spot> slots=parkingLot.getSpots();
    	Collections.sort(slots,(a,b)-> a.getPriceperHour()-b.getPriceperHour());
    	String a=numberOfWheels+"";
    	Spot slot=null;
    	for(Spot s: slots)
    	{
    		if(s.getSpotType().equals(a))
    		{
    			if(!s.getOccupaid())
    			{
    				slot=s;
    				break;
    			}
    		}
    	}
    	
    	if(slot==null) {
			throw new Exception("Cannot make reservation");
		}
    	
    	slot.setOccupaid(true);
    	spotRepository3.save(slot);
    	parkingLotRepository3.save(parkingLot);
    	
    }
}
