package com.imorochi.airline;

public class LatamAirline extends Airline {
    @Override
    public void request() {
        System.out.println("Request Server LatamAirline status: [200]");
    }
}
