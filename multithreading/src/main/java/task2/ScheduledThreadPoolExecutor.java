package task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nikolay Shuvaev on 12.06.2017.
 */
public class ScheduledThreadPoolExecutor  {
    private Lock lock;
    private Condition condition;
    private LinkedList<Task> tasks;
    private List<Worker> workers;
    private ExecutorService executorService;

    public ScheduledThreadPoolExecutor(int workersSize) {
        tasks = new LinkedList<>();
        workers = new ArrayList<>();
        executorService = Executors.newFixedThreadPool(workersSize);
        lock = new ReentrantLock();
        condition = lock.newCondition();
        init(workersSize);
    }

    private void init(int workersSize) {
        for (int i = 0; i < workersSize; i++) {
            workers.add(new Worker(tasks, lock, condition));
            executorService.submit(workers.get(i));
        }
    }

    public void shutdown() {
        lock.lock();
        try {
            while (true) {
                if (tasks.size() > 0) {
                    try {
                        condition.await(1, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                workers.forEach(Worker::interrupt);
                executorService.shutdown();
                break;
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean isShutdown() {
        return executorService.isShutdown();
    }

    public boolean isTerminated() {
        return executorService.isTerminated();
    }

    public void execute(Runnable command, long delay) {
        lock.lock();
        try {
            tasks.offer(new Task(command, delay));
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    private static class Task {

        private final Runnable runnable;
        private final long delay;

        public Task(Runnable command, long delay) {
            this.runnable = command;
            this.delay = delay;
        }

        public Runnable getRunnable() {
            return runnable;
        }

        public long getDelay() {
            return delay;
        }
    }

    private static class Worker implements Runnable {

        private LinkedList<Task> tasks;
        private Lock lock;
        private Condition condition;
        private volatile boolean interrupt;

        public Worker(LinkedList<Task> tasks, Lock lock, Condition condition) {
            this.tasks = tasks;
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            System.out.println("Worker started - " + Thread.currentThread().getName());
            while (!interrupt) {

                try {

                    lock.lock();
                    Task task = null;
                    try {
                        if (tasks.size() == 0) {
                            condition.await();
                        }

                        if (tasks.size() != 0) {
                            task = tasks.poll();
                        }
                    } finally {
                        lock.unlock();
                    }

                    if (task != null) {
                        Thread.sleep(task.getDelay());
                        task.getRunnable().run();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void interrupt() {
            this.interrupt = true;
            condition.signalAll();
        }
    }
}
