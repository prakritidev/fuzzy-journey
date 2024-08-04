package com.prakritidev.verma.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prakritidev.verma.domain.Ticket;

@SpringBootTest
public class ParkingServiceTests {

    @Autowired
    private ParkingService parkingService;

    @Test
    public void testParkVehicle() {
        Ticket ticket = parkingService.parkVehicle();
        assertNotNull(ticket);
        assertNotNull(ticket.getParkingSpot());
        assertTrue(ticket.getParkingSpot().isOccupied());
    }

    @Test
    public void testPayBill() {
        Ticket ticket = parkingService.parkVehicle();
        assertNotNull(ticket);
        boolean paid = parkingService.payBill(ticket.getId());
        assertTrue(paid);
        assertTrue(ticket.isPaid());
        assertFalse(ticket.getParkingSpot().isOccupied());
    }

    @Test
    public void testInvalidPayBill() {
        boolean paid = parkingService.payBill(999L); // Invalid ticket ID
        assertFalse(paid);
    }
}
