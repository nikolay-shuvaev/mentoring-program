package task3;

import task3.bean.MergeSortTask;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by Nikolay Shuvaev on 12.06.2017.
 */
public class SortForkJoinMain {
    public static void main(String[] args) {
        int[] ints = new Random().ints(30_000_000, 0, 1_000).toArray();

        for (int i = 0; i < 2000; i++) {
            long start = System.nanoTime();
            int[] sortedInts = ForkJoinPool.commonPool().invoke(new MergeSortTask(ints));
            long duration = System.nanoTime() - start;


            System.out.println("Result:" + sortedInts.length);


            System.out.println("Time: - " + (duration / 1_000_000));
        }
    }




}
