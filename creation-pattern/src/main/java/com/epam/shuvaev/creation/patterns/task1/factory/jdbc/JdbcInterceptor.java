package com.epam.shuvaev.creation.patterns.task1.factory.jdbc;

import com.epam.shuvaev.creation.patterns.task1.dto.Person;
import com.epam.shuvaev.creation.patterns.task1.factory.Interceptor;

import java.time.LocalDate;

/**
 * Created by macbook on 09.03.17
 */
public class JdbcInterceptor implements Interceptor {
    private static String PERSON_NAME = "Testov Test Testovich";

    @Override
    public Object inputProcess(Object input) {
        System.out.println("JDBC: prepare Person from DB Record");
        return getTempPerson();
    }

    @Override
    public Object outputProcess(Object out) {
        Person person = (Person) out;
        System.out.println("JDBC: prepare Record from Person");
        return "Record";
    }

    private Person getTempPerson() {
        return Person.of(PERSON_NAME, LocalDate.of(1990, 11, 23))
                .setAddress("Country, City, Street 55")
                .setEmail("test@test.com")
                .setTelephone("00000000");
    }
}
