package 卷一核心技术.多线程.内部锁synchronized关键字;

/**
 * 死锁
 * 在多线程程序中,同步时可能需要使用多个锁,如果获得锁的顺序 不一致,可能会导致死锁
 * 如何避免死锁?
 * 当需要获得多个锁时,所有线程获得锁的顺序保持一致即可
 */
public class Test10 {
    public static void main(String[] args) {
        SubThread t1 = new SubThread();
        t1.setName("a");
        t1.start();
        SubThread t2 = new SubThread();
        t2.setName("b");
        t2.start();
    }

    static class SubThread extends Thread {
        private static final Object lock1 = new Object();
        private static final Object lock2 = new Object();

        @Override
        public void run() {
            if ("a".equals(Thread.currentThread().getName())) {
                synchronized (lock1) {
                    System.out.println("a 线程获得了 lock1 锁,还需要获得 lock2 锁");
                    synchronized (lock2) {
                        System.out.println("a 线程获得 lock1 后又获得了 lock2,可以想干任何想干的事");
                    }
                }
            }
            if ("b".equals(Thread.currentThread().getName())) {
                synchronized (lock2) {
                    System.out.println("b 线程获得了 lock2 锁,还需要获得 lock1 锁");
                    synchronized (lock1) {
                        System.out.println("b 线程获得lock2后又获得了 lock1,可以想干任何想干的事");
                    }
                }
            }
        }
    }
}
