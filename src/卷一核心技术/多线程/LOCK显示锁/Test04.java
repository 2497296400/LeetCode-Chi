package 卷一核心技术.多线程.LOCK显示锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* ReentrantLock 锁的可重入性  */
public class Test04 {
    static class Subthread extends Thread{
        private static Lock lock = new ReentrantLock();
        //定义锁对象
        public static int num = 0;
        //定义变量
        @Override
        public void run() {
            for (int i = 0; i <10000 ; i++) {
                try {
                    //可重入锁指可以反复获得该锁
                    lock.lock();lock.lock();
                    num++;
                }finally {
                    lock.unlock();lock.unlock();
                } } }}
    public static void main(String[] args) throws InterruptedException {
        Subthread t1 = new Subthread();
        Subthread t2 = new Subthread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println( Subthread.num );
    }}