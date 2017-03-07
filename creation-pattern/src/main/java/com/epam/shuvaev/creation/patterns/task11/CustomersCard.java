package com.epam.shuvaev.creation.patterns.task11;

import com.epam.shuvaev.creation.patterns.task11.datasource.DataSource;
import com.epam.shuvaev.creation.patterns.task11.datasource.DataSourceFactory;

/**
 * Created by macbook on 07.03.17
 */
public class CustomersCard {

    private final String cardNumber;
    private final DataSource dataSource;

    public CustomersCard(String cardNumber, DataSourceFactory factory) {
        this.cardNumber = cardNumber;
        this.dataSource = factory.getDataSource();
    }

    public String getPersonsName() {
        return dataSource.getName(cardNumber);
    }

    public String getAddress() {
        return dataSource.getAddress(cardNumber);
    }

    public void updatePersonName(String name) {
        dataSource.setName(name);
    }

    public void updatePersonAddress(String address) {
        dataSource.setAddress(address);
    }
}
