package 卷一核心技术.多线程.读写锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 演示ReadWriteLock的读写互斥,一个线程获得读锁时,写线程等待; 一个线程获得写锁时,其他线程等待
 */
public class Test03 {
    static class Service {
        //先定义读写锁
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock readLock = readWriteLock.readLock();       //获得读锁
        Lock writeLock = readWriteLock.writeLock();     //获得写锁
        //定义方法读取数据
        public void read() {
            try {
                readLock.lock();       //申请获得读锁
                System.out.println(Thread.currentThread().getName() + "获得读锁,开始读取数据的时间--" + System.currentTimeMillis());
                Thread.sleep(3000);     //模拟读取数据的用时
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "读取数据完毕时的时间==" + System.currentTimeMillis());
                readLock.unlock();     //释放读锁
            }
        }

        //定义方法修改数据
        public void write() {
            try {
                writeLock.lock();       //申请获得写锁
                System.out.println(Thread.currentThread().getName() + "获得写锁,开始修改数据的时间--" + System.currentTimeMillis());
                Thread.sleep(3000);     //模拟修改数据的用时
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "修改数据完毕时的时间==" + System.currentTimeMillis());
                writeLock.unlock();     //释放写锁
            }
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        //定义一个线程读数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.read();
            }
        }).start();
        //定义一个线程写数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.write();
            }
        }).start();
    }
}