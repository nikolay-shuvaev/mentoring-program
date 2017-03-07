package com.epam.shuvaev.creation.patterns.builder.builder;

import com.epam.shuvaev.creation.patterns.builder.dto.Person;

/**
 * Created by macbook on 07.03.17
 */
public interface Builder {
    PersonInfo buildPersonInformation();

    ContactInfo buildContacts();

    AddressInfo buildAddress();

    Person build();

    interface PersonInfo {
        PersonInfo firstName(String first);

        PersonInfo middleName(String middle);

        PersonInfo lastName(String last);
    }

    interface ContactInfo {
        ContactInfo telephone(String tel);

        ContactInfo email(String email);
    }

    interface AddressInfo {

        AddressInfo country(String country);

        AddressInfo city(String city);

        AddressInfo street(String street);

        AddressInfo building(String building);
    }
}
