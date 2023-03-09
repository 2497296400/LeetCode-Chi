package 卷一核心技术.多线程.LOCK显示锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/*tryLock(long time, TimeUnit unit) 的基本使用 */
//tryLock(long time, TimeUnit unit) 的作用在给定等待时长内锁没有被另外的线程持有,并且当前线程也没有被中断,则获得该锁.通过该方法可以实现锁对象的限时等待.
public class Test07 {
    static class TimeLock implements Runnable {
        private static ReentrantLock lock = new ReentrantLock();

        //定义锁对象
        @Override
        public void run() {
            try {
                if (lock.tryLock(3, TimeUnit.SECONDS)) {//获得锁返回 true
                    System.out.println(Thread.currentThread().getName() + "获得锁,执行耗 时任务");
                    Thread.sleep(4000);
//假设 Thread-0 线程先持有锁,完成任务需要 4 秒钟,Thread-1 线程尝试获得锁,Thread-1 线程在 3 秒内还没有获得锁的话,Thread-1线程会放弃
                    Thread.sleep(2000);
//假设 Thread-0 线程先持有锁,完成任 务需要 2 秒钟,Thread-1 线程尝试获得锁,Thread-1 线程会一直尝试,在它约定尝试的 3 秒内可以获得锁对象
                } else {//没有获得锁
                    System.out.println(Thread.currentThread().getName() + "没有获得锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        TimeLock timeLock = new TimeLock();
        Thread t1 = new Thread(timeLock);
        Thread t2 = new Thread(timeLock);
        t1.start();
        t2.start();
    }
}