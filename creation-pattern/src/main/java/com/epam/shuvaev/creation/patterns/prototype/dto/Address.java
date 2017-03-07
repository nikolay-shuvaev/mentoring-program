package com.epam.shuvaev.creation.patterns.prototype.dto;

/**
 * Created by macbook on 07.03.17.
 */
public class Address implements Prototype<Address> {
    private String country;
    private String city;
    private String street;
    private String building;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}
