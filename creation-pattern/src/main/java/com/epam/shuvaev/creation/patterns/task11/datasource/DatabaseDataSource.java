package com.epam.shuvaev.creation.patterns.task11.datasource;

/**
 * Created by macbook on 07.03.17
 */
public class DatabaseDataSource implements DataSource {

    public DatabaseDataSource() {
        // init database connection
    }

    @Override
    public void setAddress(String address) {
        System.out.println("DATABASE SOURCE: Set new address: " + address);
    }

    @Override
    public void setName(String name) {
        System.out.println("DATABASE SOURCE: Set new name: " + name);
    }

    @Override
    public String getAddress(String cardNumber) {
        System.out.println("DATABASE SOURCE: Get address by card: " + cardNumber);
        return "";
    }

    @Override
    public String getName(String cardNumber) {
        System.out.println("DATABASE SOURCE: Get name by card" + cardNumber);
        return "";
    }
}
