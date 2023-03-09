package 卷一核心技术.多线程.读写锁;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 演示ReadWriteLock的writeLock()写锁是互斥的,只允许有一个线程持有
 */
public class Test02 {
    static class Service {
        //先定义读写锁
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        //定义方法修改数据
        public void write() {
            try {
                readWriteLock.writeLock().lock();       //申请获得写锁
                System.out.println(Thread.currentThread().getName() + "获得写锁,开始修改数据的时间--" + System.currentTimeMillis());
                Thread.sleep(3000);     //模拟修改数据的用时
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "修改数据完毕时的时间==" + System.currentTimeMillis());
                readWriteLock.writeLock().unlock();     //释放写锁
            }
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        //创建5个线程修改数据
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.write();    //调用修改数据的方法
                }
            }).start();//从执行结果来看,同一时间只有一个线程获得写锁
        }
    }
}