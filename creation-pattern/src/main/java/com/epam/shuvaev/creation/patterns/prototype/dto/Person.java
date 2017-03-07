package com.epam.shuvaev.creation.patterns.prototype.dto;

/**
 * Created by macbook on 07.03.17.
 */
public class Person implements Prototype<Person> {
    private String firstName;
    private String MiddleName;
    private String LastName;
    private Contact contact;
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
