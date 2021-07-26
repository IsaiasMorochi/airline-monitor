package com.imorochi;

import java.util.InputMismatchException;

import java.util.Scanner;

public class AirportMonitorApplication {

    public static void main(String[] args) {
        FlightDetails flightDetails = new FlightProxy();
        Scanner scanner = new Scanner(System.in);
        boolean leave = false;
        int option;

        while (!leave) {
            System.out.println("1. Departure");
            System.out.println("2. Arrival");
            System.out.println("3. Salir");

            try {
                System.out.println("Escribe una de las opciones:");
                option = scanner.nextInt();
                switch(option) {
                    case 1:
                        System.out.println("*******************************");
                        System.out.println("*******************************");
                        flightDetails.display();
                        System.out.println("*******************************");
                        flightDetails.showFlight(FlightType.DEPARTURE);
                        System.out.println("*******************************");
                        System.out.println("Select flight ID: ");
                        System.out.println("*******************************");
                        int flightId1 = scanner.nextInt();
                        flightDetails.click(flightId1);
                        System.out.println("*******************************");
                        flightDetails.display();
                        flightDetails.clean();
                        System.out.println("*******************************");
                        System.out.println("*******************************");
                        break;
                    case 2:
                        System.out.println("*******************************");
                        System.out.println("*******************************");
                        flightDetails.display();
                        System.out.println("*******************************");
                        flightDetails.showFlight(FlightType.ARRIVAL);
                        System.out.println("*******************************");
                        System.out.println("Select flight ID: ");
                        int flightId2 = scanner.nextInt();
                        System.out.println("*******************************");
                        flightDetails.click(flightId2);
                        System.out.println("*******************************");
                        flightDetails.display();
                        flightDetails.clean();
                        System.out.println("*******************************");
                        System.out.println("*******************************");
                        break;
                    case 3:
                        leave = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scanner.next();
            }
        }

    }
}
