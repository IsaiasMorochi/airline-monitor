package com.imorochi;

import com.imorochi.airline.AirlineType;

public class Flight implements FlightDetails {

    private Integer flightId;
    private String time;
    private AirlineType airline;
    private String flight;
    private String description;
    private String timeEstimate;
    private int belt;
    private String observation;

    public Flight(Integer flightId) {
        this.flightId = flightId;
    }

    public Flight(String time, AirlineType airline, String flight, String description, String timeEstimate, int belt, String observation) {
        this.time = time;
        this.airline = airline;
        this.flight = flight;
        this.description = description;
        this.timeEstimate = timeEstimate;
        this.belt = belt;
        this.observation = observation;
    }

    public AirlineType getAirline() {
        return airline;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "  time='" + time + '\'' +
                ", airline=" + airline +
                ", flight='" + flight + '\'' +
                ", description='" + description + '\'' +
                ", timeEstimate='" + timeEstimate + '\'' +
                ", belt=" + belt +
                ", observation='" + observation + '\'' +
                '}';
    }

    @Override
    public void display() {
        System.out.println("*******************************");
        System.out.println("Show Information flight.");
        System.out.println(this.toString());
        System.out.println("*******************************");
    }

    @Override
    public void showFlight(FlightType type) {
        System.out.println(" Flight Type: " + type.name());
    }

    @Override
    public void click(int flight) {
        System.out.println("Click Flight ID: " );
    }

    @Override
    public void clean() {

    }
}
