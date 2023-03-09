package 卷一核心技术.多线程.等待机制;

public class Test07 {
    //wait(long)带有 long 类型参数的 wait()等待,如果在参数指定的时间内没有被唤醒,超时后会自动唤醒
    public static void main(String[] args) {
        final Object obj = new Object();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        System.out.println("thread begin wait");
                        obj.wait(5000);    //如果 5000 毫秒内没有被唤醒 ,会自动唤醒
                        System.out.println("end wait....");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}}});
        t.start();
    }}