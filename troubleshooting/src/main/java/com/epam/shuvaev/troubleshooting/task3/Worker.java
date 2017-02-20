package com.epam.shuvaev.troubleshooting.task3;

import java.util.List;

/**
 * Created by NICK on 20.02.2017.
 */
public class Worker extends Thread {

    private Worker helperWorker;
    private List<String> tasks;
    private volatile boolean active;

    public Worker(int id, List<String> tasks) {
        this.tasks = tasks;
        this.active = true;
        this.setName("Worker - " + id);
    }

    @Override
    public void run() {
        while (active) {
            if (tasks.size() > 0) {
                if (helperWorker.isActive()) {
                    System.out.println("Wait " + helperWorker.getName());
                    await(500);
                    continue;
                } else {
                    System.out.println("Make work");
                    makeWork();
                    System.out.println("Done by " + this.getName());
                    active = false;
                }
            } else {
                await(2000);
            }
        }
    }

    private void makeWork() {
        await(2000);
    }

    private synchronized boolean isActive() {
        return active;
    }

    private synchronized void setActive(boolean activate) {
        active = activate;
    }

    public void setHelperWorker(Worker helperWorker) {
        this.helperWorker = helperWorker;
        return;
    }

    public Worker getHelperWorker() {
        return helperWorker;
    }

    private void await(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
