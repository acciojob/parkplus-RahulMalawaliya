package com.driver.services.impl;

import com.driver.Payment;
import com.driver.Reservation;
import com.driver.Spot;
import com.driver.model.PaymentMode;
import com.driver.repository.PaymentRepository;
import com.driver.repository.ReservationRepository;
import com.driver.services.PaymentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    ReservationRepository reservationRepository2;
    @Autowired
    PaymentRepository paymentRepository2;

    @Override
    public Payment pay(Integer reservationId, int amountSent, String mode) throws Exception {
    	
    	Reservation reservation=reservationRepository2.findById(reservationId).get();
    	Spot spot=reservation.getSpot();
    	int bill=spot.getPriceperHour()*reservation.getNumberOfHours();
    	if(amountSent<bill)
    	{
    		throw new Exception("Insufficient Amount");
    	}
    	List<String> paymentmode=new ArrayList<>();

    }
}
