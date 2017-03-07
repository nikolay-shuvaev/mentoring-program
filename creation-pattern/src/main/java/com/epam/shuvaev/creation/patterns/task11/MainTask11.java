package com.epam.shuvaev.creation.patterns.task11;

import com.epam.shuvaev.creation.patterns.task11.datasource.DataSourceFactory;
import com.epam.shuvaev.creation.patterns.task11.datasource.DatabaseDataSourceFactory;
import com.epam.shuvaev.creation.patterns.task11.datasource.FileDataSourceFactory;

/**
 * Created by macbook on 07.03.17.
 */
public class MainTask11 {
    public static void main(String[] args) {
        DataSourceFactory factory = new DatabaseDataSourceFactory();
        runWithFactory(factory);
        factory = new FileDataSourceFactory();
        runWithFactory(factory);
    }

    private static void runWithFactory(DataSourceFactory factory) {
        CustomersCard card = new CustomersCard("0000000", factory);
        card.getAddress();
        card.getPersonsName();
        card.updatePersonAddress("new address");
        card.updatePersonName("new name");
    }

}
