package com.epam.shuvaev.web.services.task2.service;

import javax.xml.ws.Endpoint;

public class MainTask2 {
    /*
    In this exercise, you will implement your own simple SOAP Web Service and Client with Java.
    Please, implement a simple SOAP Web Service that satisfies the following extract of a WSDL declaration.
     … a) Returns a random number between given the lower and upper bound.
     … b) Implement a corresponding client that uses your Web Service to simulate the lottery drawing by
     requesting six random numbers between 1 and 49.
     */

    public static void main (String args[]) throws Exception {
        Endpoint.publish("http://localhost:8080/random", new RandomInRangeWebService());
        System.out.println("Server started");
    }

}
