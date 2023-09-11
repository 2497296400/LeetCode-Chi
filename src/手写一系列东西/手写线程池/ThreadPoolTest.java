package 手写一系列东西.手写线程池;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CountDownLatch cyclicBarrier = new CountDownLatch(11);
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10, 10, 10,
                        TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new TestPolicy());
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "执行");
                cyclicBarrier.countDown();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(finalI);
            });
        }
        cyclicBarrier.await();
        System.out.println(1111);
        threadPoolExecutor.shutdown();
    }
}

class TestPolicy extends ThreadPoolExecutor.CallerRunsPolicy {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Error !!! " + r + "workQueue.size " + executor.getQueue().size());
        System.out.println(r);
        super.rejectedExecution(r, executor);
    }
}
