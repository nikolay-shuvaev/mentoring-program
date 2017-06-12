package task3.bean;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Nikolay Shuvaev on 12.06.2017.
 */
public class MergeSortTask extends RecursiveTask<int[]> {

    private int[] ints;

    public MergeSortTask(int[] ints) {
        this.ints = ints;
    }

    @Override
    protected int[] compute() {
        if (ints.length == 1) {
            return ints;
        }

        int newSize = ints.length / 2;

        MergeSortTask sortedLeft = new MergeSortTask(Arrays.copyOfRange(ints, 0, newSize));
        MergeSortTask sortedRight =  new MergeSortTask(Arrays.copyOfRange(ints, newSize, ints.length));

        sortedLeft.fork();
        sortedRight.fork();
        return merge(sortedLeft.join(), sortedRight.join());
    }

    private int[] merge(int[] sortedLeft, int[] sortedRight) {
        int[] result = new int[sortedLeft.length + sortedRight.length];

        int i = 0;
        int j = 0;
        for (int k = 0; k < result.length; k++) {
            if (i == sortedLeft.length) {
                result[k] = sortedRight[j];
                j++;
                continue;
            }

            if (j == sortedRight.length) {
                result[k] = sortedLeft[i];
                i++;
                continue;
            }

            if (sortedLeft[i] < sortedRight[j]) {
                result[k] = sortedLeft[i];
                i++;
            } else {
                result[k] = sortedRight[j];
                j++;
            }
        }
        return result;
    }
}