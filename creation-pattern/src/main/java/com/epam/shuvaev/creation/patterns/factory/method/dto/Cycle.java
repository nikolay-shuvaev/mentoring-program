package com.epam.shuvaev.creation.patterns.factory.method.dto;

/**
 * Created by macbook on 07.03.17
 */
public class Cycle implements Shape {
    private int radius;
    private String color;

    public Cycle(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
