package task3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay Shuvaev on 20.06.2017.
 */
public class Main {
    private static List<Container> memLeak = new ArrayList<>();

//     -XX:MaxMetaspaceSize=20M     - OutOfMemoryError: Metaspace
//     -Xmx10m                      - OutOfMemoryError: Java heap space
    public static void main(String[] args) {
        for (long i = 0; i < 1_000_000; i++) {
            addElement(i);
        }
        System.out.println(memLeak.size());
    }

    private static void addElement(Long i) {
        memLeak.add(new Container(i));
    }

    private static class Container {
        private List<String> array = new ArrayList<>(2_000);
        private Long value;

        public Container(Long value) {
            this.value = value;
        }
    }
}
