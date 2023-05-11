package 手写一系列东西.手写线程池;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTestTow implements Executor {
    private final int core;
    private final int Max;
    private final AtomicInteger atomicInteger;
    private final BlockingQueue<Runnable> queue;

    public ThreadTestTow(int core, int max, BlockingQueue<Runnable> queue) {
        this.core = core;
        Max = max;
        this.queue = queue;
        atomicInteger = new AtomicInteger();
    }

    @Override
    public void execute(@NotNull Runnable command) {
        if (atomicInteger.get() < core) {
            if (!addWork(command)) {
                reject();
            }
            return;
        }
        if (!queue.offer(command)) {
            if (!addWork(command)) {
                reject();
            }
        }
    }

    private void reject() {
        System.out.println("线程池已满" + atomicInteger.get());
    }

    private boolean addWork(Runnable command) {
        if (atomicInteger.get() >= Max) {
            return false;
        }
        Worker worker = new Worker(command);
        worker.thread.start();
        atomicInteger.incrementAndGet();

        return true;
    }

    private class Worker implements Runnable {
        private Runnable first;
        Thread thread;

        public Worker(Runnable command) {
            first = command;
            thread = new Thread(this);
        }

        @Override
        public void run() {
            Runnable taskRun = first;
            try {
                while (taskRun != null || (taskRun = getTask()) != null) {
                    taskRun.run();
                    if (atomicInteger.get() >= Max) {
                        break;
                    }
                    taskRun = null;
                }
            } finally {
                atomicInteger.decrementAndGet();
            }
            first = null;
        }

        private Runnable getTask() {
            for (; ; ) {
                System.out.println("WorkerSize " + queue.size());
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
