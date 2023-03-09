package 卷一核心技术.多线程.LOCK显示锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* lockInterruptibly() 方法的作用:如果当前线程未被中断则获得锁,如果当前线程被中断则
 出现异常.*/
public class Test05 {
    static class Servier {
        private Lock lock = new ReentrantLock();

        public void serviceMethod() {
            try {
                lock.lockInterruptibly();//如果线程被中断了,不会获得锁,会产生异常
                //lock.lock();//获得锁定,即使调用了线程的 interrupt()方法,也没有真正的中断线程
                System.out.println(Thread.currentThread().getName() + "-- begin lock");
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    new StringBuilder();//执行一段耗时的操作
                }
                System.out.println(Thread.currentThread().getName() + " -- end lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " ***** 释放锁");
                lock.unlock();//释放锁
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Servier s = new Servier();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                s.serviceMethod();
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
        Thread.sleep(50);
        Thread t2 = new Thread(r);
        t2.start();
        Thread.sleep(50);
        t2.interrupt();//中断 t2 线程
    }
}