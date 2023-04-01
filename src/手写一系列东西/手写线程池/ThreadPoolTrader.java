package 手写一系列东西.手写线程池;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTrader implements Executor {
    private final AtomicInteger t = new AtomicInteger(0);
    private volatile int corePoolsize;
    private volatile int maximumPoolsize;
    private final BlockingQueue<Runnable> workQueue;

    public ThreadPoolTrader(int corePoolsize, int maximumPoolsize, BlockingQueue<Runnable> workQueue) {
        this.corePoolsize = corePoolsize;
        this.maximumPoolsize = maximumPoolsize;
        this.workQueue = workQueue;
    }

    @Override
    public void execute(Runnable command) {
        int c = t.get();
        if (c < corePoolsize) {
            if (!addWork(command)) {
                reject();
            }
            return;
        }
        if (!workQueue.offer(command)) {
            if (!addWork(command)) {
                reject();
            }
        }
    }

    private void reject() {
        System.out.println("Error !!! " + t.get() + "workQueue.size " + workQueue.size());
    }

    private boolean addWork(Runnable firstTask) {
        if (t.get() >= maximumPoolsize) {
            return false;
        }
        Worker worker = new Worker(firstTask);
        worker.thread.start();
        t.incrementAndGet();
        return true;
    }

    private final class Worker implements Runnable {
        final Thread thread;
        Runnable firstTask;

        public Worker(Runnable firstTask) {
            this.firstTask = firstTask;
            thread = new Thread(this);
        }

        @Override
        public void run() {
            Runnable task = firstTask;
            try {
                while (task != null || (task = getTask()) != null) {
                    task.run();
                    if (t.get() > maximumPoolsize) {
                        break;
                    }
                    task = null;
                }
            } finally {
                t.decrementAndGet();
            }
        }

        private Runnable getTask() {
            for (; ; ) {
                try {
                    System.out.println("workQueue size " + ":" + workQueue.size());
                    return workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTrader trader = new ThreadPoolTrader(5, 10, new ArrayBlockingQueue<>(100));
        ExecutorService service = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));
        for(int  i = 0;i<100;i++){
            final  int cur  = i;
            service.execute(()->{
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务编号" + cur+"线程ID" + Thread.currentThread().getName());
            });
        }
        
    }
}
