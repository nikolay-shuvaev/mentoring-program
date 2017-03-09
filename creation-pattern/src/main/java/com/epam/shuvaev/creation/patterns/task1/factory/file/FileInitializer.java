package com.epam.shuvaev.creation.patterns.task1.factory.file;

import com.epam.shuvaev.creation.patterns.task1.factory.Initializer;

import java.io.File;
import java.io.IOException;

/**
 * Created by macbook on 09.03.17.
 */
public class FileInitializer implements Initializer {
    @Override
    public Object init() {
        System.out.println("FILE: initialize file");
        try {
            return File.createTempFile("Temp", ".txt");
        } catch (IOException e) {
            System.out.println("Fail to initialize file");
            return null;
        }
    }
}
