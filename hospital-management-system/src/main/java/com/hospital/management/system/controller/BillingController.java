package com.hospital.management.system.controller;

import com.hospital.management.system.entities.Billing;
import com.hospital.management.system.model.BillingDetails;
import com.hospital.management.system.service.BillingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/allBills")
    public ResponseEntity<List<Billing>> getAllBills() {
       List<Billing>list = billingService.getAllBills();
       return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{billId}")
    public ResponseEntity<Billing> getBillById(@PathVariable Long billId) {
        Billing billing = billingService.getBillById(billId);
        return new ResponseEntity<>(billing, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Billing> addBill( @Valid @RequestBody BillingDetails billingDetails) {
        Billing billing = billingService.addBill(billingDetails);
        return new ResponseEntity<>(billing, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{billId}")
    public  ResponseEntity<?> deleteBill(@PathVariable Long billId) {
        billingService.deleteBill(billId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}