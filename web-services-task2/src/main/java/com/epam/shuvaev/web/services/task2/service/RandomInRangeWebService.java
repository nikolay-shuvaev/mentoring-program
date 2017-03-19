package com.epam.shuvaev.web.services.task2.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Random;

@WebService
public class RandomInRangeWebService {

    @WebMethod
    public int getValue(int min, int max) {
        Random random = new Random();
        return random.ints(min, max + 1).findFirst().getAsInt();
    }
}
