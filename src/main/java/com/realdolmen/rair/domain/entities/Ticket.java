package com.realdolmen.rair.domain.entities;

import com.realdolmen.rair.domain.FlightClass;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Flight flight;

    private FlightClass flightClass;

    @ManyToOne
    private Booking booking;

    @ManyToOne
    private RegularUser owner;

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public RegularUser getOwner() {
        return owner;
    }

    public void setOwner(RegularUser owner) {
        this.owner = owner;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
