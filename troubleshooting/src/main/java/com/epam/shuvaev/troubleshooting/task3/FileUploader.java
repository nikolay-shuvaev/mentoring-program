package com.epam.shuvaev.troubleshooting.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by NICK on 19.02.2017.
 */
public class FileUploader {
    private int threads;
    private Thread[] pool;
    private List<String> files = Collections.synchronizedList(new ArrayList<>());


    public FileUploader(int threads) {
        this.threads = threads;
    }

    public void run() {
        pool = new Thread[threads];
        initializePool();
        for (Thread thread : pool) {
            thread.setName("ThreadPool");
            thread.start();
        }
    }

    private void initializePool() {
        for (int i = 0; i < threads; i++) {
            pool[i] = new Thread(() -> {
                System.out.println("Run thread from pool");
                while (true) {
                    if (files.size() > 1) {
                        continue;
                    }

                    synchronized (files) {
                        if (files.size() > 0) {
                            System.out.println("Get work");
                            String fileForProcessing = files.remove(0);
                            process(fileForProcessing);
                            System.out.println("Work done");
                        }
                    }
                }
            });
        }
    }

    /**
     * Processing file upload
     * @param fileForProcessing -
     */
    private void process(String fileForProcessing) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }


    public void addFile(String s) {
        files.add(s);
    }

}
