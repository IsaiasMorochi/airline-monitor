package com.imorochi;

import com.imorochi.airline.*;

public class FlightServerFacade {

    public Flight request(Flight flight, AirlineAgency airlineAgency) {
        System.out.println("FlightServerFacade: conversion started.");
        System.out.println(".......");
        Airline sourceAirline = airlineAgency.requestAirline(flight.getAirline());
        Flight result = ResponseTranslator.convert(flight, sourceAirline);
        System.out.println(".......");
        System.out.println("FlightServerFacade: conversion completed.");
        System.out.println(".......");
        return result;
    }
}
