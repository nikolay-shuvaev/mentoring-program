package com.epam.shuvaev.creation.patterns.task11.datasource;

/**
 * Created by macbook on 07.03.17
 */
public class FileDataSourceFactory implements DataSourceFactory {
    @Override
    public DataSource getDataSource() {
        return FileDataSource.getInstance();
    }
}
