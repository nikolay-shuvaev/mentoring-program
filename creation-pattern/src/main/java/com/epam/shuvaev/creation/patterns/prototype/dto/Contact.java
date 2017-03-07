package com.epam.shuvaev.creation.patterns.prototype.dto;

/**
 * Created by macbook on 07.03.17.
 */
public class Contact implements Prototype<Contact> {
    private String email;
    private String telephone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Contact clone() throws CloneNotSupportedException {
        return (Contact) super.clone();
    }
}
