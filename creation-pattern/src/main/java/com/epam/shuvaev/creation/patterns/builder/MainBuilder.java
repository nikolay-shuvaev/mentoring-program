package com.epam.shuvaev.creation.patterns.builder;

import com.epam.shuvaev.creation.patterns.builder.builder.Builder;
import com.epam.shuvaev.creation.patterns.builder.builder.PersonBuilder;
import com.epam.shuvaev.creation.patterns.builder.dto.Person;

/**
 * Created by macbook on 07.03.17
 */
public class MainBuilder {
    public static void main(String[] args) {
        Builder builder = new PersonBuilder();
        builder.buildPersonInformation()
                .firstName("Test")
                .middleName("Testovich")
                .lastName("Testov");
        builder.buildContacts()
                .telephone("0000000")
                .email("test@test.com");
        builder.buildAddress()
                .country("test")
                .city("test")
                .street("test")
                .building("test");

        Person person = builder.build();

        System.out.println(person);
    }
}
