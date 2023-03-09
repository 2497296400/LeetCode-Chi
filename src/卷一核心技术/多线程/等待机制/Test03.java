package 卷一核心技术.多线程.等待机制;

//需要通过 notify()唤醒等待的线程
public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        String lock = "wkcto";//定义一个字符串作为锁对象
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程 1 开始等待: " + System.currentTimeMillis());
                    try {
                        lock.wait();//线程等待,会释放锁对象,当前线程转入 blocked 阻塞状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程 1 结束等待:" + System.currentTimeMillis());
                }
            }
        });
        //定义第二个线程,在第二个线程中唤醒第一个线程
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //notify()方法也需要在同步代码块中,由锁对象调用
                synchronized (lock){
                    System.out.println("线程 2 开始唤醒 : " + System.currentTimeMillis());
                    lock.notify();
                    //唤醒在 lock 锁对象上等待的某一个线程
                    System.out.println("线程 2 结束唤醒 : " + System.currentTimeMillis());
                }
            }
        });
        t1.start();
        Thread.sleep(3000);//main 线程睡眠 3 秒,确保 t1 入睡
        t2.start();
    }}