package com.epam.shuvaev.creation.patterns.task7;

/**
 * Created by macbook on 07.03.17
 */
public class Superman {
    private static class SupermanHolder {
        private static Superman SUPERMAN = new Superman();
    }

    public static Superman getInstance() {
        return SupermanHolder.SUPERMAN;
    }
}
