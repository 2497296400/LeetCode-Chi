package 手写一系列东西.多线程的生产者消费者;

import java.util.LinkedList;
import java.util.Random;

public class Product implements Runnable {
    private final LinkedList<Integer> list;
    private int Max;

    public Product(LinkedList<Integer> list, int max) {
        this.list = list;
        Max = max;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            synchronized (list) {
                while (list.size() == Max) {
                    System.out.println("生产者已满等待消费");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                int nextInt = random.nextInt(100);
                list.add(nextInt);
                System.out.println("生产者生产");
                list.notifyAll();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
