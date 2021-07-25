package com.imorochi.airline;

public class ArrivalAirlineAgency extends AirlineAgency {

    @Override
    public Airline createAirline(AirlineType airlineTye) {
        Airline airline;

        if (airlineTye.equals(AirlineType.LATAM)) {
            airline = new LatamAirline();
        } else if (airlineTye.equals(AirlineType.PERU_MAX)) {
            airline = new PeruMaxAirline();
        } else {
            airline = null;
        }

        return airline;
    }
}
