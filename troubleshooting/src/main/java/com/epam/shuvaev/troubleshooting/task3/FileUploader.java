package com.epam.shuvaev.troubleshooting.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NICK on 19.02.2017.
 */
public class FileUploader {
    private List<String> tasks = new ArrayList<>();

    public void addFile(String s) {
        tasks.add(s);
    }

    public void upload() {
        Worker worker1 = new Worker(1, tasks);
        Worker worker2 = new Worker(2, tasks);
        worker1.setHelperWorker(worker2);
        worker2.setHelperWorker(worker1);
        worker1.start();
        worker2.start();
    }
}
