package com.imorochi;

import com.imorochi.airline.AirlineType;
import com.imorochi.airline.ArrivalAirlineAgency;
import com.imorochi.airline.DepartureAirlineAgency;

import java.util.HashMap;
import java.util.Map;

public class FlightProxy implements FlightDetails {

    protected Flight flight = null;
    protected FlightType flightType;

    Map<Integer, Flight> FLIGHT_DEPARTURES = new HashMap<Integer, Flight>() {
        {
            put(1,new Flight("07:15", AirlineType.PERU_MAX, "P9 8009", "PUNTA CANA", "-", 29, "DELAYED"));
            put(2,new Flight("07:45", AirlineType.LOGO,"AA 1558", "MIAMI", "08:51", 0, "CLOSED"));
            put(3,new Flight("09:10", AirlineType.LATAM, "LA 2377", "SAO PAULO", "09:10", 32, "CLOSED"));
            put(4,new Flight("09:15", AirlineType.LATAM, "LA 2418", "R.JANEIRO", "09:15", 28, "BOARDING"));
            put(5,new Flight("09:25", AirlineType.LATAM, "LA 609", "SANTIAGO", "11:00", 26, "LAS CALL"));
            put(6,new Flight("09:30", AirlineType.LATAM, "LA 7901", "B.AIRES", "09:30", 31, "DALAYED"));
        }
    };

    final Map<Integer, Flight> FLIGHT_ARRIVALS = new HashMap<Integer, Flight>() {
        {
            put(1,new Flight("09:25",AirlineType.LOGO, "VV 751", "CUSCO", "09:29", 0, "CONFIRMED"));
            put(2,new Flight("09:25", AirlineType.LATAM,"LA 2273", "CHICLAYO", "09:32", 0, "CONFIRMED"));
            put(3,new Flight("09:30",  AirlineType.LATAM, "LA 2191", "JAUJA", "09:11", 2, "CONFIRMED"));
            put(4,new Flight("09:30", AirlineType.PERU_MAX, "P9 231", "AREQUIPA", "09:31", 0, "CONFIRMED"));
            put(5,new Flight("09:40", AirlineType.LATAM,"LA 2116", "AREQUIPA", "09:22", 0, "CONFIRMED"));
            put(6,new Flight("09:55", AirlineType.LATAM, "LA 2235", "IQUITOS", "09:42", 0, "CONFIRMED"));
        }
    };

    @Override
    public void display() {
        if (flight != null) {
            flight.display();
        }
        System.out.println("Airline Monitor -> " );
    }

    @Override
    public void showFlight(FlightType type) {
        this.flightType = type;
        if (type.equals(FlightType.DEPARTURE)) {
            departures();
        } else if (type.equals(FlightType.ARRIVAL)) {
            arrivals();
        }
    }

    @Override
    public void click(int flightId) {
        try {
            if (flight == null) {
                FlightServerFacade facade = new FlightServerFacade();
                if (flightType.equals(FlightType.DEPARTURE)) {
                    flight = FLIGHT_DEPARTURES.get(flightId);
                    facade.request(flight,new DepartureAirlineAgency());
                }
                if (flightType.equals(FlightType.ARRIVAL)) {
                    flight = FLIGHT_ARRIVALS.get(flightId);
                    facade.request(flight,new ArrivalAirlineAgency());
                }
                flight.display();
            }
        } catch (Exception e) {
            System.out.println("NOT FOUND SERVER");
        }
    }

    public void departures() {
        for (Map.Entry<Integer, Flight> entry: FLIGHT_DEPARTURES.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void arrivals() {
        for (Map.Entry<Integer, Flight> entry : FLIGHT_DEPARTURES.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
        }
    }

}
