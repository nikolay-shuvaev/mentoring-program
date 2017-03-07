package com.epam.shuvaev.creation.patterns.task11.datasource;

/**
 * Created by macbook on 07.03.17
 */
public interface DataSource {
    void setAddress(String address);

    void setName(String name);

    String getAddress(String cardNumber);

    String getName(String cardNumber);
}
