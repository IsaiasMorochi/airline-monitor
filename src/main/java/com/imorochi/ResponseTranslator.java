package com.imorochi;

import com.imorochi.airline.Airline;

public class ResponseTranslator {

    public static Flight convert(Flight flight, Airline airline) {
        System.out.println(".......");
        System.out.println("ResponseTranslator: writing flight data...");
        return flight;
    }

}
