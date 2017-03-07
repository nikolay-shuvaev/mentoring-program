package com.epam.shuvaev.creation.patterns.builder.dto;

/**
 * Created by macbook on 07.03.17
 */
public class Contact {
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

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
