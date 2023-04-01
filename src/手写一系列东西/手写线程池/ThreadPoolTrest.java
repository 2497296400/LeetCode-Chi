package 手写一系列东西.手写线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTrest implements Executor {
    private final int corePoolSize;
    private final int maxinumSize;
    private AtomicInteger t= new AtomicInteger(0);
    private final BlockingQueue<Runnable> workQueue;

    public ThreadPoolTrest(int corePoolSize, int maxinumSize, BlockingQueue<Runnable> workQueue) {
        this.corePoolSize = corePoolSize;
        this.maxinumSize = maxinumSize;
        this.workQueue = workQueue;
    }

    @Override

    public void execute(Runnable command) {
        int c = t.get();
        if (c < corePoolSize) {
            if (!addWorker(command)) {
                refuse();
            }
            return;
        }
        if (!workQueue.offer(command)) {
            if (!addWorker(command)) {
                refuse();
            }
        }
    }

    private boolean addWorker(Runnable command) {
        if (t.get() >= maxinumSize) {
            return false;
        }
        Worker worker = new Worker(command);
        worker.thread.start();
        t.incrementAndGet();
        return true;
    }

    private void refuse() {
        System.out.println("Error !!! " + "over:" + t.get());
    }

    private class Worker implements Runnable {
        Runnable firstTask;
        Thread thread;

        public Worker(Runnable command) {
            firstTask = command;
            thread = new Thread(this);
        }

        @Override
        public void run() {
            Runnable curTask = firstTask;
            try {
            while (curTask != null || (curTask = getTask()) != null) {
                curTask.run();
                if(t.get()>=maxinumSize){
                    break;
                }
                curTask =null;
                }
            }finally {
                t.decrementAndGet();
            }
        }

        private Runnable getTask() {
            for(;;){
                try {
                    System.out.println("WorkerSize:" +" "+workQueue.size());
                    return workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTrest poolTrest = new ThreadPoolTrest(5, 10, new ArrayBlockingQueue<>(10));
        for(int i = 0;i<100;i++){
            final  int cur = i;
            poolTrest.execute(()->{
                System.out.println("当前任务"+" " + cur+" ID" + Thread.currentThread().getName());
            });
        }
    }
}
