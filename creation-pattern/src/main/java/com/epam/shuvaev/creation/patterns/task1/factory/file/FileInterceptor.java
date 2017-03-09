package com.epam.shuvaev.creation.patterns.task1.factory.file;

import com.epam.shuvaev.creation.patterns.task1.factory.Interceptor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by macbook on 09.03.17
 */
public class FileInterceptor implements Interceptor {
    @Override
    public Object inputProcess(Object input) {
        System.out.println("FILE: make buffered for read");
        FileInputStream inputStream = (FileInputStream) input;
        return new BufferedInputStream(inputStream);
    }

    @Override
    public Object outputProcess(Object out) {
        System.out.println("FILE: make buffered for write");
        FileOutputStream outputStream = (FileOutputStream) out;
        return new BufferedOutputStream(outputStream);
    }
}
