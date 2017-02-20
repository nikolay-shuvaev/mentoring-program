package com.epam.shuvaev.troubleshooting.task3;

/**
 * Created by NICK on 19.02.2017
 */
public class MainTask3 {

    private static final int NUM_OF_THREADS = 4;

    public static void main(String[] args) {
        FileUploader uploader = new FileUploader();
        uploader.addFile("test1.txt");
        uploader.upload();
    }


}
