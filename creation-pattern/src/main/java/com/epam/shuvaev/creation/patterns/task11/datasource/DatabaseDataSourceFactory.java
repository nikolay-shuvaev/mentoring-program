package com.epam.shuvaev.creation.patterns.task11.datasource;

/**
 * Created by macbook on 07.03.17.
 */
public class DatabaseDataSourceFactory implements DataSourceFactory {
    @Override
    public DataSource getDataSource() {
        return new DatabaseDataSource();
    }
}
