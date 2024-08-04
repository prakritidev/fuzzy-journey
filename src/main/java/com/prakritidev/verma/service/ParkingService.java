package com.prakritidev.verma.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prakritidev.verma.domain.ParkingSpot;
import com.prakritidev.verma.domain.Ticket;

@Service
public class ParkingService {
    private List<ParkingSpot> parkingSpots = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();
    private Long nextSpotId = 1L;
    private Long nextTicketId = 1L;

    public ParkingService() {
        for (int i = 0; i < 10; i++) {
            parkingSpots.add(new ParkingSpot(nextSpotId++));
        }
        parkingSpots.stream().forEach(System.out::println);
    }

    public Optional<ParkingSpot> findAvailableParkingSpot(){
        System.out.println(parkingSpots.stream().filter(spot -> !spot.isOccupied()).findFirst());
        return parkingSpots.stream().filter(spot -> spot.isOccupied()).findFirst();
    }

    public Ticket parkVehicle(){
        Optional<ParkingSpot> availableSpot = findAvailableParkingSpot();
        if(availableSpot.isPresent()){
            ParkingSpot spot = availableSpot.get();
            spot.setOccupied(true);
            Ticket ticket = new Ticket(nextTicketId++, spot, LocalDateTime.now());
            tickets.add(ticket);
        }
        return null;
    }

    public Optional<Ticket> findTicketById(Long id){
        return tickets.stream().filter(ticket -> ticket.getId().equals(id)).findFirst();
    }

    public boolean payBill(Long ticketId) {
        Optional<Ticket> ticket = findTicketById(ticketId);
        if (ticket.isPresent() && !ticket.get().isPaid()) {
            ticket.get().setPaid(true);
            ticket.get().getParkingSpot().setOccupied(false);
            ticket.get().setExitTime(LocalDateTime.now());
            return true;
        }
        return false;
    }

   
}
