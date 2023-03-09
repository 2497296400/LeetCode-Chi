package 卷一核心技术.多线程.等待机制;

public class Test08 {
    //线程 wait()等待后,可以调用 notify()唤醒线程, 如果 notify()唤醒的过早,在等待之前就调用了 notify()可能会打乱程序正常的运行逻辑.
    public static void main(String[] args) {
        final Object Lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Lock){
                    try {
                        System.out.println("begin wait");
                        Lock.wait();
                        System.out.println("wait end...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}} });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Lock){
                    System.out.println("begin notify");
                    Lock.notify();;
                    System.out.println("end nofity");
                }}});
//如果先开启 t2 通知线程,再开启 t1 等待线程,可能会出现 t1 线程等待没有收到通知的情况,
        t2.start();
        t1.start();
    }}