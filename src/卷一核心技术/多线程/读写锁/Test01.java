package 卷一核心技术.多线程.读写锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/** ReadWriteLock读写锁可以实现读读共享,允许多个线程同时获得读锁*/
public class Test01 {
    static class Service{
        //定义读写锁
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        //定义方法读取数据
        public void read(){
            try {
                readWriteLock.readLock().lock();        //获得读锁
                System.out.println(Thread.currentThread().getName() + "获得读锁,开始读取数据的时间--" + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(3);  //模拟读取数据用时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                readWriteLock.readLock().unlock();  //释放读锁
            }  } }

    public static void main(String[] args) {
        Service service = new Service();
        //创建5个线程,调用read()方法
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.read();     //在线程中调用read()读取数据
                }
            }).start();//运行程序后,这多个线程几乎可以同时获得锁读,执行lock()后面的代码
        } } }