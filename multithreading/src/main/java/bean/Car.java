package bean;

/**
 * Created by Nikolay Shuvaev on 11.06.2017.
 */
public class Car implements Runnable {
    private static final long MAX_DISTANCE = 10000;

    private long friction;
    private String name;
    private long distance;

    public Car(String name, long friction) {
        this.name = name;
        this.friction = 100;
    }

    @Override
    public void run() {
        try {
            while (distance < MAX_DISTANCE) {
                checkIsInterrupted();

                Thread.sleep(friction);
                distance += 100;
                System.out.println(name + " " + distance);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Disqualify " + getName());
        }
    }

    private void checkIsInterrupted() {
        if (Thread.currentThread().isInterrupted()) {
            throw new RuntimeException("Disqualify " + getName());
        }
    }

    public String getName() {
        return name;
    }
}
