package com.epam.shuvaev.web.services.task2.client;

import com.epam.shuvaev.web.services.task2.client.code_gen.RandomInRangeWebService;
import com.epam.shuvaev.web.services.task2.client.code_gen.RandomInRangeWebServiceService;

public class ClientMainTask2 {

    public static void main(String[] args) {
        RandomInRangeWebService randomInRangeWebServicePort = new RandomInRangeWebServiceService().getRandomInRangeWebServicePort();
        for (int i = 0; i < 6; i++) {
            int value = randomInRangeWebServicePort.getValue(1, 49);
            System.out.println(value);
        }
    }
}
