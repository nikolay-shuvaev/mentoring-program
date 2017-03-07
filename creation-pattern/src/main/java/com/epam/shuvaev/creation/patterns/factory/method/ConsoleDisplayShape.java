package com.epam.shuvaev.creation.patterns.factory.method;

import com.epam.shuvaev.creation.patterns.factory.method.dto.Shape;

import java.io.OutputStream;

/**
 * Created by macbook on 07.03.17
 */
public class ConsoleDisplayShape extends DisplayShape {
    public ConsoleDisplayShape(Shape[] shapes) {
        super(shapes);
    }

    @Override
    protected OutputStream getOutputStream() {
        return System.out;
    }
}
