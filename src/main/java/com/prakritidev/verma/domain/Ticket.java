package com.prakritidev.verma.domain;

import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private boolean paid;

    public Ticket(Long id, ParkingSpot parkingSpot, LocalDateTime entryTime) {
        this.id = id;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
        this.paid = false;
    }

    public Long getId() {
        return id;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
