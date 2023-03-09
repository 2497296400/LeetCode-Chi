package 卷一核心技术.多线程.等待机制;

public class test {
    //notify()一次只能唤醒一个线程,如果有多个等待的线程,只能随机 唤醒其中的某一个; 想要唤醒所有等待线程,需要调用 notifyAll().
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        SubThread t1 = new SubThread(lock);
        SubThread t2 = new SubThread(lock);
        SubThread t3 = new SubThread(lock);
        t1.setName("t1");t2.setName("t2");t3.setName("t3");
        t1.start();t2.start();t3.start();
        Thread.sleep(2000);
        synchronized (lock){
            // //调用 notify()唤醒子线程
            lock.notify();
            //调用一次 notify()只能唤醒其中的一个线程,其他等待的线程依然处于等待状态,对于处于等待状态的线程来说,错过了通知信号,这种现象也称为信号丢失
            lock.notifyAll();        //唤醒所有的线程
        }}
    static class SubThread extends Thread{
        private Object lock;
        //定义实例变量作为锁对象
        public SubThread(Object lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
            synchronized (lock){
                try {
                    System.out.println(Thread.currentThread().getName() + " -- begin wait...");
                    lock.wait();
                    System.out.println( Thread.currentThread().getName() + " -- end wait...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}}}}