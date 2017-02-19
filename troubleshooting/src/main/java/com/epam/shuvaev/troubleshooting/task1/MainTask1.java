package com.epam.shuvaev.troubleshooting.task1;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by NICK on 19.02.2017
 */
public class MainTask1 {
    public static void main(String[] args) {
        int numberOfThreads = 100;
        if (args != null && args.length > 0) {
            try {
                numberOfThreads = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Param should be a number. Continue with default value.");
            }
        }
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Await start");
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    System.out.println("Unfinished threads exist. " + e);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted " + e);
                }
                System.out.println("Running!");
                fillData();
                System.out.println("Finish!");
            });
            thread.setName("Test Thread " + i);
            thread.start();

        }
    }

    public static synchronized void fillData() {
        //Make some work
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
