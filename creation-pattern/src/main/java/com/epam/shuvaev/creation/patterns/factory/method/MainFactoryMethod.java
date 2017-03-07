package com.epam.shuvaev.creation.patterns.factory.method;

import com.epam.shuvaev.creation.patterns.factory.method.dto.Cycle;
import com.epam.shuvaev.creation.patterns.factory.method.dto.Rectangle;
import com.epam.shuvaev.creation.patterns.factory.method.dto.Shape;

/**
 * Created by macbook on 07.03.17
 */
public class MainFactoryMethod {

    public static void main(String[] args) {
        DisplayShape displayShape = new ConsoleDisplayShape(new Shape[] {
                new Cycle(4, "red"), new Rectangle(3,4)
        });
        displayShape.draw();
    }

}
