package com.epam.shuvaev.creation.patterns.task1.factory.jdbc;

import com.epam.shuvaev.creation.patterns.task1.dao.JdbcDao;
import com.epam.shuvaev.creation.patterns.task1.dao.PersonDao;
import com.epam.shuvaev.creation.patterns.task1.factory.Initializer;
import com.epam.shuvaev.creation.patterns.task1.factory.Interceptor;
import com.epam.shuvaev.creation.patterns.task1.factory.StorageFactory;

/**
 * Created by macbook on 09.03.17.
 */
public class JdbcStorageFactory implements StorageFactory {
    @Override
    public PersonDao createPersonDao(Initializer initializer, Interceptor interceptor) {
        return new JdbcDao(initializer, interceptor);
    }

    @Override
    public Initializer createtInitializer() {
        return new JdbcInitializer();
    }

    @Override
    public Interceptor createInterceptors() {
        return new JdbcInterceptor();
    }
}
