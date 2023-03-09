package 卷一核心技术.多线程.线程组;

/**
 * 线程组的批量中断
 */
public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程--" + Thread.currentThread() + "--开始循环");
                //当线程没有被中断就一直循环
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "------------------");
                 /*  try {
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       //如果中断睡眠中的线程,产生中断异常, 同时会清除中断标志
                       e.printStackTrace();
                   }*/
                }
                System.out.println(Thread.currentThread().getName() + "循环结束");
            }
        };
        //创建线程组
        ThreadGroup group = new ThreadGroup("group");
        //在group线程组中创建5个线程
        for (int i = 0; i < 5; i++) {
            new Thread(group, r).start();
        }
        //main线程睡眠2秒
        Thread.sleep(50);
        //中断线程组, 会中断线程组中所有的线程
        group.interrupt();
    }
}