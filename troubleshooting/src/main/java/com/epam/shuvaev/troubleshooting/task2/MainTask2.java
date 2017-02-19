package com.epam.shuvaev.troubleshooting.task2;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by NICK on 19.02.2017
 */
public class MainTask2 {

    private static final int NUM_OF_THREADS = 4;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM_OF_THREADS);

        Object resource1 = new Object();
        Object resource2 = new Object();
        Object resource3 = new Object();
        Object resource4 = new Object();

        new ThreadWithResources(resource1, resource2, cyclicBarrier).start();
        new ThreadWithResources(resource2, resource3, cyclicBarrier).start();
        new ThreadWithResources(resource3, resource4, cyclicBarrier).start();
        new ThreadWithResources(resource4, resource1, cyclicBarrier).start();

    }


}
