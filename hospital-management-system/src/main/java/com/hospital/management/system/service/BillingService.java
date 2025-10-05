package com.hospital.management.system.service;

import com.hospital.management.system.entities.Billing;
import com.hospital.management.system.model.BillingDetails;

import java.util.List;
import java.util.Optional;

public interface BillingService  {

    Billing addBill(BillingDetails billingDetails);
    Billing getBillById(Long billId);
    List<Billing> getAllBills();
    void deleteBill(Long billId);
}
