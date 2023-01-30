package com.driver.services;

import com.driver.ParkingLot;
import com.driver.Spot;

public interface ParkingLotService {
    
    void deleteSpot(int spotId);

    Spot updateSpot(int parkingLotId, int spotId, int pricePerHour);

    void deleteParkingLot(int parkingLotId);

    ParkingLot addParkingLot(String name, String address);

    Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour);
}
