package 卷一核心技术.多线程.LOCK显示锁;

import java.util.concurrent.locks.ReentrantLock;

//tryLock()当锁对象没有被其他线程持有的情况下才会获得该锁定
public class Test08 {
    static class Service {
        private ReentrantLock lock = new ReentrantLock();

        public void serviceMethod() {
            try {
                if (lock.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + "获得锁定");
                    Thread.sleep(3000);//模拟执行任务的时长
                } else {
                    System.out.println(Thread.currentThread().getName() + "没有获得锁定 ");
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

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod();
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
        Thread.sleep(50);//睡眠 50 毫秒,确保 t1 线程锁定
        Thread t2 = new Thread(r);
        t2.start();
    }
}