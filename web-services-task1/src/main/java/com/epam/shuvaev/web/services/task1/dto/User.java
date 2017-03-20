package com.epam.shuvaev.web.services.task1.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nikolay Shuvaev on 20.03.2017
 */
@XmlRootElement
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String email;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
