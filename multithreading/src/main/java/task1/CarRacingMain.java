package task1;

import task1.bean.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nikolay Shuvaev on 11.06.2017.
 */
public class CarRacingMain {
    private volatile String winner;

    public static void main(String[] args) {
        CarRacingMain race = new CarRacingMain();
        System.out.println("Start race");
        race.start(new Car[]{
                new Car("Car #1", 0L),
                new Car("Car #2", 0L),
                new Car("Car #3", 0L),
                new Car("Car #4", 0L),
                new Car("Car #5", 0L),
                new Car("Car #6", 0L),
                new Car("Car #7", 0L),
        });

        System.out.println("Winner is " + race.getWinner() + "!");
    }

    private void start(Car[] cars) {

        List<Thread> runners = prepareRace(cars);

        runners.forEach(Thread::start);

        disqualifyOneCar(cars, runners);

        waitTheEndOfRace(runners);
    }

    private void waitTheEndOfRace(List<Thread> runners) {
        for (Thread runner : runners) {
            try {
                runner.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void disqualifyOneCar(Car[] cars, List<Thread> runners) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int carId = ThreadLocalRandom.current().nextInt(cars.length);
        System.out.println("Try to disqualify " + cars[carId].getName());
        runners.get(carId).interrupt();
    }

    private List<Thread> prepareRace(Car[] cars) {
        List<Thread> runners = new ArrayList<>(cars.length);

        CountDownLatch latch = new CountDownLatch(cars.length);
        Lock lock = new ReentrantLock();
        for (Car car : cars) {
            runners.add(new Thread(() -> {
                System.out.println("Ready to start!!");
                try {
                    latch.countDown();
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Goooooo!! [" + car.getName() + "]" );

                try {
                    car.run();

                    lock.lock();
                    if (winner == null) {
                        System.out.println("Write winner!");
                        winner = car.getName();
                    }
                    lock.unlock();
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }));
        }
        return runners;
    }

    public String getWinner() {
        return winner;
    }
}
