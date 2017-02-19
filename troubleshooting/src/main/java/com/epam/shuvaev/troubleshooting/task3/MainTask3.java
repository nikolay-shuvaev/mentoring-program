package com.epam.shuvaev.troubleshooting.task3;

/**
 * Created by NICK on 19.02.2017
 */
public class MainTask3 {

    private static final int NUM_OF_THREADS = 4;

    public static void main(String[] args) {
        FileUploader uploader = new FileUploader(4);
//        uploader.run();
        uploader.addFile("test1.txt");
        uploader.addFile("test2.txt");
        uploader.addFile("test3.txt");
        uploader.addFile("test4.txt");
        uploader.run();
    }


}
