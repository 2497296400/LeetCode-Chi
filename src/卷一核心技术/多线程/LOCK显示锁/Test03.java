package 卷一核心技术.多线程.LOCK显示锁;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test03 {
    //使用 Lock 锁同步不同方法中的同步代码块
    static Lock lock = new ReentrantLock();//同步代码块的锁使用的同一个锁

    //定义锁对象
    public static void sm1() {
        //经常在 try 代码块中获得 Lock 锁, 在 finally 子句中释放锁
        try {
            lock.lock();//获得锁
            System.out.println(Thread.currentThread().getName() + "-- method 1 -- " + System.currentTimeMillis());
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(Thread.currentThread().getName() + "-- method 1 -- " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁
        }
    }

    public static void sm2() {
        try {
            lock.lock();//获得锁
            System.out.println(Thread.currentThread().getName() + "-- method 22 -- " + System.currentTimeMillis());
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(Thread.currentThread().getName() + "-- method 22 -- " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                sm1();
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                sm2();
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}