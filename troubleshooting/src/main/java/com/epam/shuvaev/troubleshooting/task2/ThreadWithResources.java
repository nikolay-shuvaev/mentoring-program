package com.epam.shuvaev.troubleshooting.task2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by NICK on 19.02.2017.
 */
public class ThreadWithResources extends Thread {

    private Object res1;
    private Object res2;
    private CyclicBarrier cyclicBarrier;

    public ThreadWithResources(Object res1, Object res2, CyclicBarrier cyclicBarrier) {
        this.res1 = res1;
        this.res2 = res2;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        waitAllThreads();

        System.out.println("Running");
        synchronized (res1) {
            waitALittleBit();
            synchronized (res2) {
                System.out.println("Make work");
            }
        }
        System.out.println("Done!");
    }

    private void waitALittleBit() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    private void waitAllThreads() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        } catch (BrokenBarrierException e) {
            System.out.println("Some threads are running");
        }
    }
}
