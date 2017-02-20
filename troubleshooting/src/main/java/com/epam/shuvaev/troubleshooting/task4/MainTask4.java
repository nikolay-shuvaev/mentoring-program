package com.epam.shuvaev.troubleshooting.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NICK on 19.02.2017
 */
public class MainTask4 {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<String>();
        BufferedReader fileReader = new BufferedReader(new FileReader("troubleshooting/src/main/java/com/epam/shuvaev/troubleshooting/task4/test_data.txt"));
        String line;
        while ((line = fileReader.readLine()) != null) {
            if (line.length() > 3) {
                String threeFirst = line.substring(0, 3);
                list.add(threeFirst);
                waitForHeapDump();
             }
        }

        fileReader.close();
        System.out.println("Done");
    }

    private static void waitForHeapDump() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
