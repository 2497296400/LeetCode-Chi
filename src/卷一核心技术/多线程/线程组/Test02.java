package 卷一核心技术.多线程.线程组;

/** 演示线程组的基本操作 */
public class Test02 {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();    //返回当前线程组
        //再定义线程组
        ThreadGroup group = new ThreadGroup("group");  //默认group的父线程组是main线程组
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("-----------当前线程: " + Thread.currentThread());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } }  } };
        Thread t1 = new Thread(r, "t1");        //默认在main线程组中创建线程
        Thread t2 = new Thread(group, r, "t2");     //在指定的group线程组中创建线程
        t1.start();
        t2.start();
        //打印线程组的相关属性
        System.out.println("main 线程组中活动线程数量: " + mainGroup.activeCount());  		//4, main线程组中活动线程: main, t1, t2, 垃圾回收器
        System.out.println("group 子线程组中活动线程数量: " + group.activeCount());    			//1,  t2
        System.out.println("main线程组中子线程组数量: " + mainGroup.activeGroupCount());  //1,  group
        System.out.println("group子线程组中子线程组数量: " + group.activeGroupCount());    //0
        System.out.println("main线程组的父线程组: " + mainGroup.getParent());   		//main线程组的父线程组是system
        System.out.println("group线程组的父线程组: " + group.getParent());  //main
        System.out.println( mainGroup.parentOf(mainGroup));//true, 线程组也是它自己的父线程组
        System.out.println( mainGroup.parentOf(group));     //true
        mainGroup.list();   //把main线程组中所有的线程打印输出
    } }