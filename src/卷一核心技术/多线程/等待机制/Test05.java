package 卷一核心技术.多线程.等待机制;

//Interrupt()会中断线程的 wait()等待
public class Test05 {
    //当线程处于 wait()等待状态时, 调用线程对象的 interrupt()方法会中断线程的等待状态, 会产生 InterruptedException 异常
    public static void main(String[] args) throws InterruptedException {
        SubThread t = new SubThread();
        t.start();
        Thread.sleep(2000);//主线程睡眠 2 秒, 确保子线程处于 Wait 等待状态
        t.interrupt();
    }

    private static final Object LOCK = new Object();

    //定义常量作为锁对象
    static class SubThread extends Thread {
        @Override
        public void run() {
            synchronized (LOCK) {
                try {
                    System.out.println("begin wait...");
                    LOCK.wait();
                    System.out.println("end wait..");
                } catch (InterruptedException e) {
                    System.out.println("wait 等待被中断了****");
                }
            }
        }
    }
}
