package com.epam.shuvaev.creation.patterns.task1.factory.file;

import com.epam.shuvaev.creation.patterns.task1.dao.FileDao;
import com.epam.shuvaev.creation.patterns.task1.dao.PersonDao;
import com.epam.shuvaev.creation.patterns.task1.factory.Initializer;
import com.epam.shuvaev.creation.patterns.task1.factory.Interceptor;
import com.epam.shuvaev.creation.patterns.task1.factory.StorageFactory;

/**
 * Created by macbook on 09.03.17
 */
public class FileStorageFactory implements StorageFactory {
    @Override
    public PersonDao createPersonDao(Initializer initializer, Interceptor interceptor) {
        return new FileDao(initializer, interceptor);
    }

    @Override
    public Initializer createtInitializer() {
        return new FileInitializer();
    }

    @Override
    public Interceptor createInterceptors() {
        return new FileInterceptor();
    }
}
