package 卷一核心技术.多线程.LOCK显示锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test02 {
    //定义显示锁
    static Lock lock = new ReentrantLock();
    //定义方法
    public static void sm(){
        //先获得锁
        lock.lock();
        //for 循环就是同步代码块 ========================
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " -- " + i);
        }
        //释放锁 	=========================================
        lock.unlock();
    }
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                sm();
            }
        };
//启动三个线程
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }}
