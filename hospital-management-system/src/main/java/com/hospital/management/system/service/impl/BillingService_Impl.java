package com.hospital.management.system.service.impl;

import com.hospital.management.system.entities.Billing;
import com.hospital.management.system.exception.BillNotFoundException;
import com.hospital.management.system.model.BillingDetails;
import com.hospital.management.system.repository.AppointmentRepository;
import com.hospital.management.system.repository.BillingRepository;
import com.hospital.management.system.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService_Impl implements BillingService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    BillingRepository billingRepository;

    @Override
    public Billing addBill(BillingDetails billingDetails) {
        return createBill(billingDetails);
    }

    private Billing createBill(BillingDetails billingDetails) {
        Billing billing = new Billing();
        billing.setAmount(billingDetails.getAmount());
        billing.setStatus(billingDetails.getStatus());
        billing.setAppointment(appointmentRepository.findById(billingDetails.getAppointmentId()).get());
        return billingRepository.save(billing);
    }

    @Override
    public Billing getBillById(Long billId) {
        Optional<Billing> optional = billingRepository.findById(billId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new BillNotFoundException("Bill is not present with this id : " + billId);
        }
    }

    @Override
    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }

    @Override
    public void deleteBill(Long billId) {
        billingRepository.deleteById(billId);
    }
}
