package 卷一核心技术.多线程.线程组;

/* 演示复制线程组中的内容*/
public class Test03 {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();//返回main线程main线程组
        //main线程组中定义了两个子线程组
        ThreadGroup group1 = new ThreadGroup("group1");     //默认group1的父线程组就是当前线程组main
        ThreadGroup group2 = new ThreadGroup(mainGroup, "group2");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("----当前线程: " + Thread.currentThread());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //创建并启动三个线程
        Thread t1 = new Thread(r, "t1");    //默认在main线程组中创建线程
        Thread t2 = new Thread(group1, r, "t2");    //在group1线程组中创建线程
        Thread t3 = new Thread(group2, r, "t3");    //在group2线程组中创建线程
        t1.start();
        t2.start();
        t3.start();
        //1) 把main线程组中的线程复制到数组中
        //先定义存储线程的数组,数组的长度为main线程组中活动线程的数量
        Thread[] threadList = new Thread[mainGroup.activeCount()];

    /*       //把main线程组包括子线程组中的所有的线程复制到数组中
       mainGroup.enumerate(threadList);
       //遍历threadList数组
       for (Thread thread : threadList) {
           System.out.println(thread);
       }
       System.out.println("----------------------------");*/

        //只把main线程组中的线程复制到数组中,不包含子线程组的线程
        mainGroup.enumerate(threadList, false);
        //遍历threadList数组
        for (Thread thread : threadList) {
            System.out.println(thread);
        }
        System.out.println("----------------------------");
        //2) 把main线程组中的子线程组复制到数组中
        //定义数组存储线程组
        ThreadGroup[] threadGroups = new ThreadGroup[mainGroup.activeGroupCount()];
        //把main线程组中的子线程组复制到数组中
        mainGroup.enumerate(threadGroups);
        System.out.println("============================");
        for (ThreadGroup threadGroup : threadGroups) {
            System.out.println(threadGroup);
        }
    }
}