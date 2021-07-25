package com.imorochi.airline;

public abstract class AirlineAgency {

    public abstract Airline createAirline(AirlineType airlineTye);

    public Airline requestAirline(AirlineType airlineTye) {
        Airline airline = this.createAirline(airlineTye);
        if (airline == null) {
            System.out.println("Server Not Found.");
        } else {
            airline.request();
        }
        return airline;
    }
}
