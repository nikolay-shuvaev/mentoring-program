package com.epam.shuvaev.creation.patterns.task1.factory;

import com.epam.shuvaev.creation.patterns.task1.dao.PersonDao;

/**
 * Created by macbook on 09.03.17
 */
public interface StorageFactory {
    PersonDao createPersonDao(Initializer initializer, Interceptor interceptor);

    Initializer createtInitializer();

    Interceptor createInterceptors();
}
