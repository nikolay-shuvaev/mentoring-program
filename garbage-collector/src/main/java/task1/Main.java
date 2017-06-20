package task1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nikolay Shuvaev on 18.06.2017.
 */
public class Main {
//    -XX:+UseSerialGC -Xms6m -Xmx18m -Xmn2m -XX:MetaspaceSize=20M -XX:MaxMetaspaceSize=30M
//    -XX:+UseParallelGC -Xms3m -Xmx12m -Xmn1m -XX:MetaspaceSize=20M -XX:MaxMetaspaceSize=20M
//    -XX:+UseParallelOldGC -Xms9m -Xmx18m -Xmn3m -XX:MetaspaceSize=40m
//    -XX:+UseConcMarkSweepGC  -XX:ConcGCThreads=2 -Xms6m -Xmx18m -Xmn2m -XX:MetaspaceSize=20M -XX:MetaspaceSize=30m
//    -XX:+UseG1GC -Xms4m -Xmx16m -Xmn2m -XX:MetaspaceSize=12M -XX:MetaspaceSize=18m
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 3_000_000; i++) {
            ArrayList<Object> objects = new ArrayList<>(new Random().nextInt(10_000));
            for (int j = 0; j < objects.size(); j++) {
                objects.add(new String("Hello" + j));
            }
            System.out.println("created");
            objects = null;
            Thread.sleep(20);
        }

    }

    private static void createArrayList(int size) {

    }

    /*
     Write a simple program that repeatedly creates some objects structure (for example ArrayList collection) and
     then release memory (set reference to null). Please note that in order to avoid JVM optimizations
     use some kind of randomness. Then try to run this program using different types of GC (listed below)
     and monitor memory utilization using Java VisualVm.
     Use the following GC configurations:
     1) Serial Collector with the following parameters the 6m initial heap size for when the JVM starts the
     18m maximum heap size the 2m size of the Young Generation the 20m starting size of the Permanent Generation
     the 30 maximum size of the Permanent Generation
     2) Parallel Collector with the following parameters the 3m initial heap size for when the JVM starts the12m
     maximum heap size the1m size of the Young Generation the 20m starting size of the Permanent Generation
     the 20 maximum size of the Permanent Generation
     3) Parallel Old Collector with the following parameters the 9m initial heap size for when the JVM starts the18m
     maximum heap size the3m size of the Young Generation the 40m starting size of the Permanent Generation
     the 40 maximum size of the Permanent Generation
     4) Concurrent Mark Sweep (CMS) Collector with 2 Parallel CMS Threads with the following parameters the 6m initial
     heap size for when the JVM starts the18m maximum heap size the 2m size of the Young Generation the 20m starting
     size of the Permanent Generation the 30 maximum size of the Permanent Generatio
     5) G1 Garbage Collector with the following parameters the 4m initial heap size for when the JVM starts the16m
     maximum heap size them 2m size of the Young Generation the 12m starting size of the Permanent Generation the 18
     maximum size of the Permanent Generation

     What should we get in result in repository: Source code of the program
     README file with all GC command line configuration parameters Screenshots from VisualVM for all types of GC
     running for 5 mins.
     */
}
