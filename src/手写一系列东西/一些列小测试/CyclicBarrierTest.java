package 手写一系列东西.一些列小测试;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class CyclicBarrierTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(11);
        Semaphore semaphore = new Semaphore(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("线程" + Thread.currentThread().getName() + "开始执行");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "执行完毕");
            }).start();
        }
        cyclicBarrier.await();
        
        System.out.println("主线程执行完毕");
    }
}
