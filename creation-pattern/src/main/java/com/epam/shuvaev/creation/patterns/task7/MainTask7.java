package com.epam.shuvaev.creation.patterns.task7;

/**
 * Created by macbook on 07.03.17
 */
public class MainTask7 {
    public static void main(String[] args) {
        System.out.println(Superman.getInstance());
        System.out.println("Is instances equals: " + (Superman.getInstance() == Superman.getInstance()));
    }
}
