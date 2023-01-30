package com.driver.services;

import com.driver.Payment;

public interface PaymentService {
    Payment pay(Integer reservationId, int amountSent, String mode) throws Exception;
}
