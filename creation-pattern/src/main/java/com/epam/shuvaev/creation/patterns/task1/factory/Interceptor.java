package com.epam.shuvaev.creation.patterns.task1.factory;

/**
 * Created by macbook on 09.03.17
 */
public interface Interceptor {
    Object inputProcess(Object input);

    Object outputProcess(Object out);
}
