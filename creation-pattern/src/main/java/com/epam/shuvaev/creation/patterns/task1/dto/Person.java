package com.epam.shuvaev.creation.patterns.task1.dto;

import java.time.LocalDate;

/**
 * Created by macbook on 09.03.17.
 */
public class Person {
    private String name;
    private LocalDate birthday;
    private String telephone;
    private String email;
    private String address;

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public Person setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Person setAddress(String address) {
        this.address = address;
        return this;
    }

    public static Person of(String name, LocalDate birthday) {
        return new Person(name, birthday);
    }

    @Override
    public String toString() {
        return "Person{\n" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                "\n}";
    }
}
