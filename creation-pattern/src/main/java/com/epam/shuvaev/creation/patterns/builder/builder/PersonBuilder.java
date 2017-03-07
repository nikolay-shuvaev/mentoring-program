package com.epam.shuvaev.creation.patterns.builder.builder;

import com.epam.shuvaev.creation.patterns.builder.dto.Address;
import com.epam.shuvaev.creation.patterns.builder.dto.Contact;
import com.epam.shuvaev.creation.patterns.builder.dto.Person;

/**
 * Created by macbook on 07.03.17
 */
public class PersonBuilder implements Builder {
    Person person = new Person();

    @Override
    public PersonInfo buildPersonInformation() {
        return new PersonInfo() {
            @Override
            public PersonInfo firstName(String first) {
                person.setFirstName(first);
                return this;
            }

            @Override
            public PersonInfo middleName(String middle) {
                person.setMiddleName(middle);
                return this;
            }

            @Override
            public PersonInfo lastName(String last) {
                person.setLastName(last);
                return this;
            }
        };
    }

    @Override
    public ContactInfo buildContacts() {
        person.setContact(new Contact());
        return new ContactInfo() {
            @Override
            public ContactInfo telephone(String tel) {
                person.getContact().setTelephone(tel);
                return this;
            }

            @Override
            public ContactInfo email(String email) {
                person.getContact().setEmail(email);
                return this;
            }
        };
    }

    @Override
    public AddressInfo buildAddress() {
        person.setAddress(new Address());
        return new AddressInfo() {
            @Override
            public AddressInfo country(String country) {
                person.getAddress().setCountry(country);
                return this;
            }

            @Override
            public AddressInfo city(String city) {
                person.getAddress().setCity(city);
                return this;
            }

            @Override
            public AddressInfo street(String street) {
                person.getAddress().setStreet(street);
                return this;
            }

            @Override
            public AddressInfo building(String building) {
                person.getAddress().setBuilding(building);
                return this;
            }
        };
    }

    @Override
    public Person build() {
        return person;
    }


}
