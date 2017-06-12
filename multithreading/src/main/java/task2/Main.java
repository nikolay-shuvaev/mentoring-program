package task2;

/**
 * Created by Nikolay Shuvaev on 12.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor( 4);
        scheduledThreadPoolExecutor.execute(() -> System.out.println("Hello World!"), 5000);
        scheduledThreadPoolExecutor.execute(() -> System.out.println("Task 1"), 4000);
        scheduledThreadPoolExecutor.execute(() -> System.out.println("Task 2"), 3000);
        scheduledThreadPoolExecutor.execute(() -> System.out.println("Task 3"), 2000);
        scheduledThreadPoolExecutor.execute(() -> System.out.println("Task 4"), 1000);
        scheduledThreadPoolExecutor.execute(() -> System.out.println("Task 5"), 0);

        scheduledThreadPoolExecutor.shutdown();
    }
}
