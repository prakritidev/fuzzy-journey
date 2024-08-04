package com.prakritidev.verma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.prakritidev.verma.domain.Ticket;
import com.prakritidev.verma.service.ParkingService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ParkingController {
    
    @Autowired
    private ParkingService parkingService;

    @PostMapping("/park")
    public ResponseEntity<?> parkVehicle() {
        Ticket ticket = parkingService.parkVehicle();
        if(ticket != null) {
            return ResponseEntity.ok(ticket);
        }
        return ResponseEntity.status(503).body("No Space is avaible");
    }
    
    @PostMapping("/pay/{ticketId}")
    public ResponseEntity<?> payBill(@RequestBody Long ticketId) {
        boolean success = parkingService.payBill(ticketId);
        if(success) return ResponseEntity.ok("payment Successfull");

        return ResponseEntity.badRequest().body("Invalid ticket ID or bill already paid.");
    }
    
}
