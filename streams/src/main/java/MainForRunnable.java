import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Created by Nikolai_Shuvaev on 6/2/2017.
 */
public class MainForRunnable {
    public static void main(String[] args) throws InterruptedException {
        Stream<Runnable> stream = Stream.of(
                () -> System.out.println("Hello, I'm from stream"),
                () -> {
                    int i = 0;
                    for (int j = 0; j < 100; j++) {
                        i++;
                    }
                    System.out.println("Print i = " + i);
                }
        );

        stream.forEach(runnable -> new Thread(runnable).start());

        TimeUnit.SECONDS.sleep(3);
    }
}
