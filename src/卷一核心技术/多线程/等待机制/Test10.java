package 卷一核心技术.多线程.等待机制;

import java.util.ArrayList;
import java.util.List;

/**
 * wait 条件发生变化
 * 定义一个集合
 * 定义一个线程向集合中添加数据,添加完数据后通知另外的线程从集合中取数据
 * 定义一个线程从集合中取数据,如果集合中没有数据就等待
 * 北京动力节点老崔
 */
public class Test10 {
    //1)定义 List 集合
    static List list = new ArrayList<>();

    public static void main(String[] args) {
//定义添加数据的线程对象
        ThreadAdd threadAdd = new ThreadAdd();
//定义取数据的线程对象
        ThreadSubtract threadSubtract = new ThreadSubtract();
        threadSubtract.setName("subtract 1 ");
//测试一: 先开启添加数据的线程,再开启一个取数据的线程,大多数情况下会正常取数据
//
        threadAdd.start();
//
        threadSubtract.start();
//测试二: 先开启取数据的线程,再开启添加数据的线程, 取数据的线程会先等待,等到添加数据之后, 再取数据
//
        threadSubtract.start();
//
        threadAdd.start();
//测试三: 开启两个 取数据的线程,再开启添加数据的线程
        ThreadSubtract threadSubtract2 = new ThreadSubtract();
        threadSubtract2.setName("subtract 2 ");
        threadSubtract.start();
        threadSubtract2.start();
        threadAdd.start();
/*
某一次执行结果如下:
        subtract 1 begin wait....
        subtract 2 从集合中取了 data 后,集合中数据的数量:0
        subtract 1 end wait..
        Exception in thread "subtract 1 " java.lang.IndexOutOfBoundsException:
分析可能的执行顺序:
        threadSubtract 线程先启动, 取数据时,集合中没有数据,wait()等待
        threadAdd 线程获得 CPU 执行权, 添加数据 , 把 threadSubtract 线程唤醒,
        threadSubtract2 线程开启后获得 CPU 执行权, 正常取数据
        threadSubtract 线程获得 CPU 执行权, 打印 end wait..., 然后再执行
        list.remove(0) 取 数 据 时 , 现 在 list 集合中已经没有数据了 , 这 时 会 产 生
        java.lang.IndexOutOfBoundsException 异常
出现异常的原因是: 向 list 集合中添加了一个数据,remove()了两次
如何解决?
当等待的线程被唤醒后, 再判断一次集合中是否有数据可取. 即需要把sutract()方法中的 if 判断改为 while
*/
    }

    //2)定义方法从集合中取数据
    public static void subtract() {
        synchronized (list) {
            if (list.size() == 0) {
                while (list.size() == 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " begin wait....");
                        list.wait();//等待
                        System.out.println(Thread.currentThread().getName() + " end wait..");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object data = list.remove(0);//从集合中取出一个数据
                System.out.println(Thread.currentThread().getName() + "从集合中取了" + data + "后,集合中数据的数量:" + list.size());
            }
        }
    }

    //3)定义方法向集合中添加数据后,通知等待的线程取数据
    public static void add() {
        synchronized (list) {
            list.add("data");
            System.out.println(Thread.currentThread().getName() + "存储了一个数据");
            list.notifyAll();
        }
    }
}
//4)定义线程类调用 add()取据的方法
class ThreadAdd extends Thread {
    @Override
    public void run() {
        Test10.add();
    }
}

//定义线程类调用 subtract()方法
class ThreadSubtract extends Thread {
    @Override
    public void run() {
        Test10.subtract();
    }
}