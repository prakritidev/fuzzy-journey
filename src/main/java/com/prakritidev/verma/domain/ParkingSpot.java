package com.prakritidev.verma.domain;

/**
 * ParkingSpot
 */
public class ParkingSpot {

    private Long id;
    private Boolean occupied = false;

    // Constructors, getters, and setters
    public ParkingSpot(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public String toString() {
        return "ParkingSpot [id=" + id + ", occupied=" + occupied + ", getId()=" + getId() + ", isOccupied()="
                + isOccupied() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
    

}