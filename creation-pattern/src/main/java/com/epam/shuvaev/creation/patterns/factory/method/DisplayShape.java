package com.epam.shuvaev.creation.patterns.factory.method;

import com.epam.shuvaev.creation.patterns.factory.method.dto.Shape;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by macbook on 07.03.17
 */
public abstract class DisplayShape {
    private Shape[] shapes;

    public DisplayShape(Shape[] shapes) {

        this.shapes = shapes;
    }

    public void draw() {
        OutputStream outputStream = getOutputStream();
        for (Shape shape : shapes) {
            try {
                outputStream.write(shape.toString().getBytes());
            } catch (IOException e) {
                System.out.println("Writing error");
            }
        }
    }

    protected abstract OutputStream getOutputStream();
}
